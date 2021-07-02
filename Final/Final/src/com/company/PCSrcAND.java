package com.company;

public class PCSrcAND {

    public String inBranch;
    public Boolean inZero;
    public String PCSrcOut;

    public void execute(){//implementa AND
        System.out.println("\n------------------ Entrou no PCSrcAND ------------------");

        inBranch = Control.getInstance().Branch;
        inZero = ALU.getInstance().output_zero;

        System.out.println("          - Valor Input InBranch = "+inBranch);
        System.out.println("          - Valor Input InZero = "+inZero);

        if(inBranch.equalsIgnoreCase("1") && inZero) PCSrcOut = "1";
        else PCSrcOut = "0";

        System.out.println("          - Valor Output = "+PCSrcOut);
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
