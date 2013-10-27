package com.orange.training.designpatterns.factory.method;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 23:59
 * To change this template use File | Settings | File Templates.
 */
public class PizzaStoreTest {
    @Test
    public void testOrderPizza() throws Exception {

        PizzaStore store = new RomanianPizzaStore();

        store.orderPizza("cheese");
    }

    @Test
    public void testOrderPizzaAbstractFactory() throws Exception {

        PizzaStore store = StoreAbstractFactory.getStore("Romanian");

        store.orderPizza("cheese");
    }


}
