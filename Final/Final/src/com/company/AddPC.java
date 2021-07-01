package com.company;

public class AddPC {

    public int add;
    
    public void Add(int Add){
        System.out.println("Entrou no add PC | valor = "+add);
        add = Add + 4;
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
