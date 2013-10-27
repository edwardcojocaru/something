package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 28.10.2013
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class StoreAbstractFactory {

    public static PizzaStore getStore(String region) {
        if ("Romania".equals(region)) {
            return new RomanianPizzaStore();
        } else {
            return new ItalianPizzaStore();
        }
    }
}
