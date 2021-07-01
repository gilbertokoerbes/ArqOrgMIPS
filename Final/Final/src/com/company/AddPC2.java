package com.company;

public class AddPC2 {
    

    public int add1 = AddPC.getInstance().add; //recebe
    public String shiftLeft1; //recebe
    public int AddPC2Result; //sai



    public int somaPC_Add2(){
        shiftLeft1 = Shiftleft1.getInstance().Shift;
        System.out.println("Chegou no add PC2. | valores (add1, shiftleft1) =" + add1 + "" + shiftLeft1);
        AddPC2Result = add1 + Integer.parseInt(shiftLeft1);
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
