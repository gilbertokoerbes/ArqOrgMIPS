package com.company;

public class Control {

    public String RegDest;
    public String Jump;
    public String Branch;
    public String MemRead;
    public String MemReg;
    public int[] ALUOp = new int[2]; //ALUOp[0] = ALUOp1 || ALUOp[1] = ALUOp2
    public String MemWrite;
    public String ALUSre; // AluSrc
    public String RegWrite;





    public void ControlInput(String input){
        if(input.equalsIgnoreCase("000000")){//type-R => addu | slt |  and | srl
            RegDest = "1";
            ALUSre = "0";
            MemReg = "0";
            RegWrite = "1";
            MemRead = "0";
            MemWrite = "0";
            Branch = "0";
            ALUOp[0]=1;
            ALUOp[1]=0;
            Jump = "0";
        }
        else if (input.equalsIgnoreCase("000010")){ //Jump
            RegDest = "0";
            MemWrite="0";
            Jump = "1";
        }
        else if (input.equalsIgnoreCase("100011")){ //lw
            RegDest = "0";
            ALUSre = "1";
            MemReg = "1";
            RegWrite = "1";
            MemRead = "0";
            MemWrite = "0";
            Branch = "0";
            ALUOp[0]=0;
            ALUOp[1]=0;
            Jump = "0";
        }
        else if (input.equalsIgnoreCase("101011")){ //sw
            RegDest = "0";
            ALUSre = "1";
            //MemReg ; não aplica
            RegWrite = "0";
            MemRead = "0";
            MemWrite = "1";
            Branch = "0";
            ALUOp[0]=0;
            ALUOp[1]=0;
            Jump = "0";
        }
        else if (input.equalsIgnoreCase("000101")){ //bne
            //RegDest = "0";
            ALUSre = "0";
            //MemReg ; não aplica
            RegWrite = "0";
            MemRead = "0";
            MemWrite = "0";
            Branch = "1";
            ALUOp[0]=0;
            ALUOp[1]=1;
            Jump = "0";
        }
        else if (input.equalsIgnoreCase("000101")){ //
            //RegDest = "0";
            ALUSre = "0";
            //MemReg ; não aplica
            RegWrite = "0";
            MemRead = "0";
            MemWrite = "0";
            Branch = "1";
            ALUOp[0]=0;
            ALUOp[1]=1;
            Jump = "0";
        }
        


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
