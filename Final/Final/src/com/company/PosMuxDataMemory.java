package com.company;

public class PosMuxDataMemory {


    private static PosMuxDataMemory uniqueInstance;
    
    private PosMuxDataMemory() {
    }

    public static synchronized PosMuxDataMemory getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PosMuxDataMemory();
        return uniqueInstance;
    }
    
    
}
