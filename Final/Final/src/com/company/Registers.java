package com.company;

public class Registers {

    public String readRegister1; //utilizamos string para manter os 0's a esquerda 
    public String readRegister2; //utilizamos string para manter os 0's a esquerda 
    public String writeRegister; //utilizamos string para manter os 0's a esquerda 
    public String writeData ="";

    public String readData1;
    public String readData2;


    public void execute(){ //executa quando contem os parametros necessário (dipapardo por PreMuxRegister)


    }

    public void outPuts(String rdData1, String rdData2){
        ALU.getInstance().Alu1 = rdData2;
        
        PreMuxAlu.getInstance().Mux0 = rdData1;
        PreMuxAlu.getInstance().selectMux();

    }


    private static Registers uniqueInstance;
    
    private Registers() {
    }

    public static synchronized Registers getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Registers();
        return uniqueInstance;
    }
    
}
