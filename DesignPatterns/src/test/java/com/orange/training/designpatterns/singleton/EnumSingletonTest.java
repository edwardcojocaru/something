package com.orange.training.designpatterns.singleton;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class EnumSingletonTest {

    @Test
    public void testShowMeTheMoney() throws Exception {

        assertTrue(EnumSingleton.INSTANCE == EnumSingleton.INSTANCE);

    }
}
