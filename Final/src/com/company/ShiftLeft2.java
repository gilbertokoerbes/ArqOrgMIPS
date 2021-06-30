package com.company;

public class ShiftLeft2 {

    private static ShiftLeft2 uniqueInstance;
    
    private ShiftLeft2() {
    }

    public static synchronized ShiftLeft2 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ShiftLeft2();
        return uniqueInstance;
    }
    
}
