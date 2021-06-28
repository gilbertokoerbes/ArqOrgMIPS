package com.company;

public class Registers {


    private static Registers uniqueInstance;
    
    private Registers() {
    }

    public static synchronized Registers getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Registers();
        return uniqueInstance;
    }
    
}
