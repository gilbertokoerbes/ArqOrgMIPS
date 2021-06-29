package com.company;

public class Control {

    public int RegDest;
    public int Jump;
    public int Branch;
    public int MemRead;
    public int MemReg;
    public int ALUOp;
    public int MemWrite;
    public int ALUSre;
    public int RegWrite;





    public void ControlInput(String input){

        //calcular valores dos fios


    }

    private static Control uniqueInstance;

    private Control() {
        }

    public static synchronized Control getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Control();

        return uniqueInstance;
    }

}
