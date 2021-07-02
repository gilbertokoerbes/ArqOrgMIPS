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

        System.out.println("\n------------------ Entrou no control ------------------");
        System.out.println("                    * Selecionando Instrução... *");
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
            System.out.println("          - Intrução = type-R => addu | slt |  and | srl");
        }
        else if (input.equalsIgnoreCase("000010")){ //Jump
            RegDest = "0";
            MemWrite="0";
            Jump = "1";
            System.out.println("          - Intrução = Jump");
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
            System.out.println("          - Intrução = lw");
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
            System.out.println("          - sw");
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
            System.out.println("          - bne");
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
            System.out.println("          - Intrução = Outra");
        }    
    }

    public void ControleExecucao(){
                //faz o controle das execuções de cada bloco
                PreMuxRegister.getInstance().selectMux();
                Registers.getInstance().execute();
                SignExtend.getInstance().execute();
                PreMuxAlu.getInstance().selectMux();
                AluControl.getInstance().set_output_ALUControl();
                ALU.getInstance().set_op_ALU();
                DataMemory.getInstance().execute();
                PosMuxDataMemory.getInstance().selectMux();
                AddPC.getInstance().Add(PC.getInstance().PCAtual);
                //ShiftLeft2.getInstance().ExecuteShift(InputSft); executado em Instruction;
                JumpAdress.getInstance().executeJumpCalc();
                Shiftleft1.getInstance().ExecuteShift(SignExtend.getInstance().signEXTENDIn);
                AddPC2.getInstance().somaPC_Add2();
                PCSrcAND.getInstance().execute();
                MuxPC.getInstance().selectMuxPC();
                MuxJump.getInstance().selectMuxPC();

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
