package com.company;

public class AluControl {


    private static AluControl uniqueInstance;
    
    private AluControl() {
    }

    public static synchronized AluControl getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AluControl();
        return uniqueInstance;
    }
    
}
