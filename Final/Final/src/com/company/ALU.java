package com.company;

public class ALU {



    public String Alu1;
    public String Alu2;




    private static ALU uniqueInstance;
    
    private ALU() {
    }

    public static synchronized ALU getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ALU();
        return uniqueInstance;
    }
    
}
