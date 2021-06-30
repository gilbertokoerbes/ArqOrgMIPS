package com.company;

public class ALU {

    public String inputRegisters;
    public String inputPreMuxAlu;
    public String opMode_AluControl = AluControl.getInstance().output_AluControl;
    public boolean output_ALU1 = false;
    public String outputALU2;
    //public String String_opMode_AluControl;

        
    public void set_op_ALU(){

        if(opMode_AluControl.equals("000")){
            opMode_AluControl = "Add";        
        }
        else if(opMode_AluControl.equals("001")){
            opMode_AluControl = "Sub";
        }
        else if(opMode_AluControl.equals("010")){
            opMode_AluControl = "And";
        }
        else if(opMode_AluControl.equals("011")){
            opMode_AluControl = "Or";
        }
        else if(opMode_AluControl.equals("100")){
            opMode_AluControl = "Not";
        }
        /*else if(opMode_AluControl.equals("101")){
            opMode_AluControl = "ShiftLeft";
''        }
        else if(opMode_AluControl.equals("110")){
            opMode_AluControl = "ShiftRight";
        }*/
    }

    private static ALU uniqueInstance;
    
    private ALU() {

    }

    public static synchronized ALU getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ALU();
        return uniqueInstance;
    }     

} 
