package com.company;

public class PreMuxAlu {

    public String Mux0; 
    public String Mux1;

    public void selectMux(){

        //Ver como sincronizar signExtend com register

        /*
        String MuxOut ="";
        if (Control.getInstance().ALUSre == 0) MuxOut = Mux0;
        else if(Control.getInstance().ALUSre == 1) MuxOut = Mux1;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");
        Registers.getInstance().writeRegister = MuxOut;
        Registers.getInstance().execute();*/
    }




    private static PreMuxAlu uniqueInstance;
    
    private PreMuxAlu() {
    }

    public static synchronized PreMuxAlu getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PreMuxAlu();
        return uniqueInstance;
    }
    
    
}
