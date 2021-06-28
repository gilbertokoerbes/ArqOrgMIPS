package com.company;

import java.util.ArrayList;

public class InstructionMemory {

    ArrayList<String> Instrutions = new ArrayList<>();
    private final int InitialPC = 4194304; //trabalhamos com inteiros
    Boolean FirstInstruc = false;//para primeira execução, PC insere TRUE
    

    public void CarregarInstrucoes(String instrucao){
        Instrutions.add(instrucao);
    }

    
    public void readAdress(int PC){
        int searchInstrucAdress;
        if(FirstInstruc) searchInstrucAdress = (PC - InitialPC);//primeira instrução estpa no inicio de PC
        else searchInstrucAdress = (PC - InitialPC)/4;

        String Readinstruc = Instrutions.get(searchInstrucAdress);        
        outInstruction(Readinstruc); 
    }

    public void outInstruction(String instruction){//representa o fio de saida de InstructionMemory
        
        Control.getInstance().ControlInput(instruction.substring(31, 26));
        

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
