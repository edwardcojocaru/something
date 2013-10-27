package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class RomanianStyleVeggiePizza extends Pizza {
    public RomanianStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Veggie Sauce";

        toppings.add("Grated Veggie.");
    }
}
