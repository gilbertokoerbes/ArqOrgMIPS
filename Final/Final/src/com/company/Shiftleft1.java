package com.company;

public class Shiftleft1 {

    public String Shift; 
    
    public void ExecuteShift(String InputSft){
        System.out.println("\n------------------ Entrou no ShiftLeft1 ------------------");
        System.out.println("          - Valor InputShift = "+InputSft);
        this.Shift = InputSft;
        Shift = Shift.substring(2, Shift.length()) + "00";
        System.out.println("          - Valor Saída InputShift = "+InputSft);
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
