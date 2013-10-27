package com.orange.training.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class SerializedSingleton implements Serializable {

    public static final Logger LOGGER = LoggerFactory.getLogger(SerializedSingleton.class);

    private static final SerializedSingleton INSTANCE = new SerializedSingleton();

    private SerializedSingleton() {
        LOGGER.info("SerializedSingleton Constructor");
    }

    public static SerializedSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        LOGGER.info("Read resolve...");
        return INSTANCE;
    }

}
