package com.company;

public class Shiftleft1 {

    public String Shift; 
    
    public void ExecuteShift(String InputSft){
        System.out.println("Entrou no shiftLeft1. | valor = " + InputSft);
        this.Shift = InputSft;
        Shift = Shift.substring(2, Shift.length()+1) + "00";
        System.out.println("Valor saida shiftLeft1 = "+ InputSft);
    }




    private static Shiftleft1 uniqueInstance;
    
    private Shiftleft1() {
    }

    public static synchronized Shiftleft1 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Shiftleft1();
        return uniqueInstance;
    }
    
}
