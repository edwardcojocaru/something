package com.orange.training.designpatterns.factory.method.optimistic;

import com.orange.training.designpatterns.factory.method.RomanianStyleCheesePizza;
import com.orange.training.designpatterns.factory.method.RomanianStyleVeggiePizza;
import com.orange.training.designpatterns.factory.method.Pizza;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */
public class OptimisticPizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    private Pizza createPizza(String type) {
        if ("cheese".equals(type))
            return new RomanianStyleCheesePizza();
        else if ("veggie".equals(type))
            return new RomanianStyleVeggiePizza();
        else
            throw new IllegalArgumentException("Not in the menu exception");
    }
}
