package com.company;

public class PosMuxDataMemory {


    public String input1 = DataMemory.getInstance().output_dataMemory;
    public String input0 = ALU.getInstance().outputALU;

    public void selectMux(){

        //Ver como sincronizar signExtend com register
        System.out.println("\n------------------ Entrou no PosMuxDataMemory ------------------");
        System.out.println("          - Valor Mux0 = "+input0);
        System.out.println("          - Valor Mux1 = "+input1);
        String MuxOut ="";
        if (Control.getInstance().ALUSre.equalsIgnoreCase("0")) MuxOut = input0;
        else if(Control.getInstance().ALUSre.equalsIgnoreCase("1")) MuxOut = input1;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");
        System.out.println("          - Valor MuxOut = "+MuxOut);

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
