package com.company;

public class MuxPC {





    private static MuxPC uniqueInstance;
    
    private MuxPC() {
    }

    public static synchronized MuxPC getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new MuxPC();
        return uniqueInstance;
    }
    
}
