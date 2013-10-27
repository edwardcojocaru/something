package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class RomanianStyleCheesePizza extends Pizza {
    public RomanianStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese.");
    }
}
