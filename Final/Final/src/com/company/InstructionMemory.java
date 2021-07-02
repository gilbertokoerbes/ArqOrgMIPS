package com.company;

import java.util.ArrayList;

public class InstructionMemory {

    ArrayList<String> Instrutions = new ArrayList<>(); //array com instruções
    private final int InitialPC = PC.getInstance().InitialPC; //trabalhamos com inteiros
    Boolean FirstInstruc = false;//para primeira execução, PC insere TRUE
    

    
    public void readAdress(int PC){
        System.out.println("                    * Lendo Endereço... *");
        int searchInstrucAdress;
        if(FirstInstruc) searchInstrucAdress = (PC - InitialPC);//primeira instrução TRUE no inicio de PC
        else searchInstrucAdress = (PC - InitialPC)/4;
        FirstInstruc = false;//reseta apos a primeria instrução

        String Readinstruc = Instrutions.get(searchInstrucAdress);
        System.out.println("          - Instrução = "+Readinstruc);
        outInstruction(Readinstruc); 
    }

    public void outInstruction(String instruction){//representa o fio de saida de InstructionMemory
        
        //Control.getInstance().ControlInput(instruction.substring(31, 26));//Encaminha para control
        //Registers.getInstance().readRegister1 = instruction.substring(25, 21);
        //Registers.getInstance().readRegister2 = instruction.substring(20, 16);
        //PreMuxRegister.getInstance().Mux0 = instruction.substring(20, 16);
        //PreMuxRegister.getInstance().Mux1 = instruction.substring(15, 11);
        //AluControl.getInstance().input_InstrucMem = instruction.substring(5,0);
        //ALU.getInstance().set_op_ALU();
        //PreMuxRegister.getInstance().selectMux();
        
        Control.getInstance().ControlInput(instruction.substring(0, 6));//Encaminha para control
        Registers.getInstance().readRegister1 = instruction.substring(6, 11);
        Registers.getInstance().readRegister2 = instruction.substring(11, 16);
        PreMuxRegister.getInstance().Mux0 = instruction.substring(11, 16);
        PreMuxRegister.getInstance().Mux1 = instruction.substring(16, 21);
        SignExtend.getInstance().signEXTENDIn = instruction.substring(21, 32);
        AluControl.getInstance().input_InstrucMem = instruction.substring(26,32);        
        ShiftLeft2.getInstance().ExecuteShift(instruction.substring(6, 32));        
        //Faz execucao
        Control.getInstance().ControleExecucao();     
        //ALU.getInstance().set_op_ALU();
        //PreMuxRegister.getInstance().selectMux();
    }
    

    public void CarregarInstrucoes(String instrucao){//carrega a lista de execuções
        System.out.println("\n-------- Entrou no InstructionMemory e gravou a Instrução --------");
        Instrutions.add(instrucao);
    }

    private static InstructionMemory uniqueInstance;
    
    private InstructionMemory() {
    }

    public static synchronized InstructionMemory getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new InstructionMemory();
        return uniqueInstance;
    }
    
}
