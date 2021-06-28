package com.company;

public class AddPC2 {


    private static AddPC2 uniqueInstance;
    
    private AddPC2() {
    }

    public static synchronized AddPC2 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddPC2();
        return uniqueInstance;
    }
    
}
