package com.company;

public class PreMuxRegister {

    public String Mux0; 
    public String Mux1;


    public void selectMux(){
        String MuxOut ="";
        if (Control.getInstance().RegDest == "0") MuxOut = Mux0;
        else if(Control.getInstance().RegDest == "1") MuxOut = Mux1;
        else System.out.println("SEM SELEÇÃO DE MUX");

        Registers.getInstance().writeRegister = MuxOut;
        Registers.getInstance().execute();
    }

    private static PreMuxRegister uniqueInstance;
    
    private PreMuxRegister() {
    }

    public static synchronized PreMuxRegister getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PreMuxRegister();
        return uniqueInstance;
    }
    
}
