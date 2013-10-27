package com.orange.training.designpatterns.singleton;

import com.orange.training.utils.RepeatRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 23:28
 * To change this template use File | Settings | File Templates.
 */
public class DoubleCheckingSingletonTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoubleCheckingSingletonTest.class);

    public static final int NUMBER_OF_THREADS = 1000;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 5)
    public void testGetInstance() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        LOGGER.info("Creating a caller for singleton...");
        DoubleCheckingSingletonCaller callable = new DoubleCheckingSingletonCaller();

        LOGGER.info("Creating n callers for singleton...");
        List<DoubleCheckingSingletonCaller> callables = Collections.nCopies(NUMBER_OF_THREADS, callable);

        LOGGER.info("Calling singletons ...");
        executor.invokeAll(callables);

        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static class DoubleCheckingSingletonCaller implements Callable<DoubleCheckingSingleton> {

        @Override
        public DoubleCheckingSingleton call() {
            return DoubleCheckingSingleton.getInstance();
        }
    }
}
