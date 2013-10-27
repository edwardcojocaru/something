package com.orange.training.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSingleton implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerSingleton.class);

    private static SimpleSingleton singleton;

    public static final AtomicInteger COUNTER = new AtomicInteger(0);

    private SimpleSingleton() {
        COUNTER.incrementAndGet();
    }

    public static SimpleSingleton getInstance() {
        if (singleton == null) {
            singleton = new SimpleSingleton();
        }
        return singleton;
    }

}
