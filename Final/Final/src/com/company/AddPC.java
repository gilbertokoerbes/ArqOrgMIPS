package com.company;

public class AddPC {

    public int add;
    
    public void Add(int Add){
        System.out.println("\n------------------ Entrou no AddPC ------------------");
        add = Add + 4;
        System.out.println("          - Valor PC pós incremento = "+add);
    }

    private static AddPC uniqueInstance;
    
    private AddPC() {
    }

    public static synchronized AddPC getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddPC();
        return uniqueInstance;
    }
    
}
