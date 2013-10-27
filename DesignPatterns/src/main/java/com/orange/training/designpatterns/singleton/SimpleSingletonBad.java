package com.orange.training.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSingletonBad {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerSingleton.class);

    private static SimpleSingletonBad singleton;

    /* Missing something important */

    public static SimpleSingletonBad getInstance() {
        if (singleton == null) {
            singleton = new SimpleSingletonBad();
        }
        return singleton;
    }

}
