package com.orange.training.designpatterns.factory.method;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 30.09.2013
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class ItalianStyleCheesePizza extends Pizza {
    public ItalianStyleCheesePizza() {
        name = "Italian Style Deep Dish Cheese Pizza";
        dough = "Extra Thin Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese.");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into square slices.");
    }
}
