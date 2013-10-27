package com.orange.training.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class ContainerSingleton {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerSingleton.class);

    private ContainerSingleton() {
        LOGGER.info("ContainerSingleton Constructor");
    }

    private static ContainerSingleton getInstance() {
        LOGGER.info("Getting singleton...");
        return SingletonHolder.CONTAINER_SINGLETON;
    }

    private static class SingletonHolder {
        private static final ContainerSingleton CONTAINER_SINGLETON = new ContainerSingleton();
    }
}
