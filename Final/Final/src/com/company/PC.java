package com.company;

public class PC {



    public void Iniciar(){
        CarregaPrograma cr = new CarregaPrograma();
        cr.carregaInstrucoes();
        //cr carrega Dados
        InstructionMemory.getInstance().FirstInstruc = true;
        InstructionMemory.getInstance().readAdress(4194304);//valor inicial de pC = primeira instrução
        
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
