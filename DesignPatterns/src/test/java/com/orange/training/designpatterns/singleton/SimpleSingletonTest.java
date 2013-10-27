package com.orange.training.designpatterns.singleton;

import com.orange.training.utils.RepeatRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSingletonTest {

    public static final int NUMBER_OF_THREADS = 1000;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 10)
    public void testGetInstance() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        SimpleSingletonCaller callable = new SimpleSingletonCaller();

        List<SimpleSingletonCaller> callables = Collections.nCopies(NUMBER_OF_THREADS, callable);
        executor.invokeAll(callables);

        executor.awaitTermination(2, TimeUnit.SECONDS);

        assertEquals(1, SimpleSingleton.COUNTER.get());
    }

    private static class SimpleSingletonCaller implements Callable<SimpleSingleton> {

        @Override
        public SimpleSingleton call() {
            return SimpleSingleton.getInstance();
        }
    }
}
