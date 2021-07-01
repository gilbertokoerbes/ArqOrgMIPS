package com.company;

public class PC {

    public final int InitialPC = 4194304; //trabalhamos com inteiros
    public int PCAtual;


    public void Iniciar(){
        
        CarregaPrograma.getInstance().carregaInstrucoes();
        //cr carrega Dados
        InstructionMemory.getInstance().FirstInstruc = true;
        nextExecution(InitialPC);
        AddPC.getInstance().Add(InitialPC); 

    }
    
    public void nextExecution(int PC){        
        this.PCAtual = PC;
        InstructionMemory.getInstance().readAdress(PCAtual);
        AddPC.getInstance().Add(PC); 
    }

    




    private static PC uniqueInstance;
    
    private PC() {
    }

    public static synchronized PC getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PC();
        return uniqueInstance;
    }
    
    
}
