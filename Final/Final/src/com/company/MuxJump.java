package com.company;

public class MuxJump {


    private static MuxJump uniqueInstance;
    
    private MuxJump() {
    }

    public static synchronized MuxJump getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new MuxJump();
        return uniqueInstance;
    }
    
}
