package com.company;

public class AddPC {


    

    private static AddPC uniqueInstance;
    
    private AddPC() {
    }

    public static synchronized AddPC getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddPC();
        return uniqueInstance;
    }
    
}
