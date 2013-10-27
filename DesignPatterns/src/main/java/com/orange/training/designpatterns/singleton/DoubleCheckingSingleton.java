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
public class DoubleCheckingSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerSingleton.class);

    /** volatile is mandatory to have atomic operations over singleton member */
    private volatile static DoubleCheckingSingleton singleton;

    private DoubleCheckingSingleton() {
        LOGGER.info("DoubleCheckingSingleton Constructor");
        if (singleton != null) {
            throw new IllegalArgumentException("Too many instances...");
        }
    }

    public static DoubleCheckingSingleton getInstance() {

        if (singleton == null) {
            synchronized (DoubleCheckingSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckingSingleton();
                }
            }
        }

        return singleton;
    }
}
