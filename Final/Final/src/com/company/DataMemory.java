package com.company;

public class DataMemory {

    public String adress = ALU.getInstance().outputALU;
    public String write_data = Registers.getInstance().writeData;
    public String output_dataMemory="";

    public void execute(){
        System.out.println("Executando data memory sem dados");
    }


    private static DataMemory uniqueInstance;
    
    private DataMemory() {
    }

    public static synchronized DataMemory getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new DataMemory();
        return uniqueInstance;
    }
    
}
