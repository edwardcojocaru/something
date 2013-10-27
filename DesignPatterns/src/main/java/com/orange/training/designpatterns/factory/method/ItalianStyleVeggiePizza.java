package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class ItalianStyleVeggiePizza extends Pizza {
    public ItalianStyleVeggiePizza() {
        name = "Italian Style Deep Dish Veggie Pizza";
        dough = "Extra Thin Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Fresh Veggie.");
    }
}
