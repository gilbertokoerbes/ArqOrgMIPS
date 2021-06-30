package com.company;

public class DataMemory {


    private static DataMemory uniqueInstance;
    
    private DataMemory() {
    }

    public static synchronized DataMemory getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new DataMemory();
        return uniqueInstance;
    }
    
}
