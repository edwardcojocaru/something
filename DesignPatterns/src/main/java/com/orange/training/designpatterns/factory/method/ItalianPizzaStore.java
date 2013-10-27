package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class ItalianPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type))
            return new ItalianStyleCheesePizza();
        else if ("veggie".equals(type)) {
            return new ItalianStyleVeggiePizza();
        }
        return null;
    }
}
