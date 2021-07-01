package com.company;

public class PosMuxDataMemory {


    public String input1 = DataMemory.getInstance().output_dataMemory;
    public String input0 = ALU.getInstance().outputALU;

    public void selectMux(){

        //Ver como sincronizar signExtend com register
        System.out.println("Fazendo MUX posDatamemory");
        String MuxOut ="";
        if (Control.getInstance().ALUSre.equalsIgnoreCase("0")) MuxOut = input0;
        else if(Control.getInstance().ALUSre.equalsIgnoreCase("1")) MuxOut = input1;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");    

        Registers.getInstance().saveDataRegister(MuxOut); 
    }



    private static PosMuxDataMemory uniqueInstance;
    
    private PosMuxDataMemory() {
    }

    public static synchronized PosMuxDataMemory getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PosMuxDataMemory();
        return uniqueInstance;
    }
    
    
}
