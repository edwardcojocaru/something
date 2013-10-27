package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
