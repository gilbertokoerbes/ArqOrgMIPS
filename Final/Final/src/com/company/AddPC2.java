package com.company;

public class AddPC2 {
    

    public int add1 = AddPC.getInstance().add; //recebe
    public String shiftLeft1; //recebe
    public int AddPC2Result; //sai



    public int somaPC_Add2(){
        System.out.println("\n------------------ Entrou no AddPC2 ------------------");
        shiftLeft1 = Shiftleft1.getInstance().Shift;
        System.out.println("          - Valor add1 = "+ add1);
        System.out.println("          - Valor ShiftLeft1 = " + shiftLeft1);
        AddPC2Result = add1 + Integer.parseInt(shiftLeft1);
        System.out.println("          - Valor Output = " + AddPC2Result);
        return AddPC2Result;
    }

    private static AddPC2 uniqueInstance;
    
    private AddPC2() {
    }

    public static synchronized AddPC2 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddPC2();
        return uniqueInstance;
    }
    
}
