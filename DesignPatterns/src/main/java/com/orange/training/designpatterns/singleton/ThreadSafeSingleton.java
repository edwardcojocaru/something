package com.orange.training.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class ThreadSafeSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerSingleton.class);

    private static ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {
        LOGGER.info("ThreadSafeSingleton Constructor");
    }

    /**
     * Poor performance due to synchronization on a static member.
     *
     * @return the singleton instance
     */
    public synchronized static ThreadSafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new ThreadSafeSingleton();
        }

        return singleton;
    }
}
