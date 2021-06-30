package com.company;

public class AluControl {

    public String input_InstrucMem;
    public int[] input_ALUOp = {Control.getInstance().ALUOp[0], Control.getInstance().ALUOp[1]};
    public String output_AluControl;
    

    private static AluControl uniqueInstance;
    
    private AluControl() {
    }

    public static synchronized AluControl getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AluControl();
        return uniqueInstance;
    }
}
