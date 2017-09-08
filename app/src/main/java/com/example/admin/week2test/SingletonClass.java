package com.example.admin.week2test;

/**
 * Created by Admin on 9/8/2017.
 */

class SingletonClass {

    private static SingletonClass single_instance = null;

    public String x;

    private SingletonClass() {
        x = "Test";
    }

    public static SingletonClass getInstance() {
        if (single_instance != null)
            return single_instance;
        else
            return single_instance = new SingletonClass();
    }
}


