package com.company;

public class Shiftleft1 {

    public String InputShift;

    public void ExecuteShift(String InputShift){
        this.InputShift = InputShift;
        InputShift = InputShift.substring(beginIndex, endIndex)

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
