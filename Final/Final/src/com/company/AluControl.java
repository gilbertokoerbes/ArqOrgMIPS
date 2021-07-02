package com.company;

public class AluControl {

    public String input_InstrucMem;
    public int[] input_ALUOp = {Control.getInstance().ALUOp[0], Control.getInstance().ALUOp[1]};
    public String output_AluControl;
    

    private static AluControl uniqueInstance;

    public void set_output_ALUControl(){

        System.out.println("\n------------------ Entrou no AluControl ------------------");
        System.out.println("          - Valor Input_InstrucMemory = "+ input_InstrucMem);
        System.out.println("          - Valor ALUOP[0] = " +  input_ALUOp[0]);
        System.out.println("          - Valor ALUOP[1] = " +  input_ALUOp[1]);
        if(this.input_ALUOp[0] == 0 && this.input_ALUOp[1] == 0){
            this.output_AluControl = "010";
        }
        else if(input_ALUOp[1] == 1){
            this.output_AluControl = "110";
        }
        else if(input_ALUOp[0] == 1){
            //ADDU = xx0001
            //if(input_InstrucMem.charAt(5) == '1' && input_InstrucMem.charAt(4) == '0' && input_InstrucMem.charAt(3) == '0' && input_InstrucMem.charAt(2) == '0'){
            //    this.output_AluControl = "010";
            //}
            if(input_InstrucMem.contains("0001")) this.output_AluControl = "010";

            else if(input_InstrucMem.charAt(5) == 0 && input_InstrucMem.charAt(4) == 1 && input_InstrucMem.charAt(3) == 0 && input_InstrucMem.charAt(2) == 0){
                this.output_AluControl = "110";
            }
            else if(input_InstrucMem.charAt(5) == 0 && input_InstrucMem.charAt(4) == 0 && input_InstrucMem.charAt(3) == 1 && input_InstrucMem.charAt(2) == 0){
                this.output_AluControl = "000";
            }
            else if(input_InstrucMem.charAt(5) == 1 && input_InstrucMem.charAt(4) == 0 && input_InstrucMem.charAt(3) == 1 && input_InstrucMem.charAt(2) == 0){
                this.output_AluControl = "010";
            }
            else{
                this.output_AluControl = "111";
            }
        }
        System.out.println("          - Valor Output AluControl = " + output_AluControl);
    }
    
    private AluControl() {
    }

    public static synchronized AluControl getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AluControl();
        return uniqueInstance;
    }
}
