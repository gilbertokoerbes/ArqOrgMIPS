package com.company;

public class ShiftLeft2 {

    public String Shift2;

    public void ExecuteShift(String InputSft){
        this.Shift2 = InputSft;//valor recebido de InstructionMemory (25 - 0)
        Shift2 = Shift2.substring(2, Shift2.length()) + "00";
    }


    private static ShiftLeft2 uniqueInstance;
    
    private ShiftLeft2() {
    }

    public static synchronized ShiftLeft2 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ShiftLeft2();
        return uniqueInstance;
    }
    
}
