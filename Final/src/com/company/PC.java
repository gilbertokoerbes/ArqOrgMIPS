package com.company;

public class PC {

    public final int InitialPC = 4194304; //trabalhamos com inteiros


    public void Iniciar(){
        
        CarregaPrograma.getInstance().carregaInstrucoes();
        //cr carrega Dados
        InstructionMemory.getInstance().FirstInstruc = true;
        InstructionMemory.getInstance().readAdress(InitialPC);
        AddPC.getInstance().Add(InitialPC);
        


        
    }
    
    public void nextExecution(int PC){

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
