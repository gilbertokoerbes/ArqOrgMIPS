package com.company;

public class PreMuxRegister {


    private static PreMuxRegister uniqueInstance;
    
    private PreMuxRegister() {
    }

    public static synchronized PreMuxRegister getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PreMuxRegister();
        return uniqueInstance;
    }
    
}
