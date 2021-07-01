package com.company;

public class PCSrcAND {

    public String inBranch;
    public Boolean inZero;
    public String PCSrcOut;

    public void execute(){//implementa AND

        inBranch = Control.getInstance().Branch;
        inZero = ALU.getInstance().output_zero;

        if(inBranch.equalsIgnoreCase("1") && inZero) PCSrcOut = "1";
        else PCSrcOut = "0";
    }

    
    private static PCSrcAND uniqueInstance;

    private PCSrcAND() {
    }

    public static synchronized PCSrcAND getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PCSrcAND();
        return uniqueInstance;
    }
    
    
}
