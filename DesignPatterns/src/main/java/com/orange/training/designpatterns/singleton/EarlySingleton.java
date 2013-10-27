package com.orange.training.designpatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public class EarlySingleton {

    public static final EarlySingleton INSTANCE = new EarlySingleton();

    private EarlySingleton() {
    }

    public static EarlySingleton getInstance() {
        return EarlySingleton.INSTANCE;
    }
}
