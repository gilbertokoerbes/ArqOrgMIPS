package com.company;

public class JumpAdress {

    int PC_4;
    String ShiftL;
    int JumpCalculado;

    public void executeJumpCalc(){
    
    ShiftL = ShiftLeft2.getInstance().Shift2;//pega o valor de shift2
    PC_4 = AddPC.getInstance().add;//pega o valor de PC somado
    String PCAtual = Integer.toBinaryString(PC_4);

    while(PCAtual.length()<31) PCAtual = "0"+PCAtual; //concatena se necessario


    String JumpAdress = PCAtual.substring(0, 4) + ShiftL;
    Integer.parseInt(JumpAdress, 2);
    }

    private static JumpAdress uniqueInstance;
    
    private JumpAdress() {
    }

    public static synchronized JumpAdress getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new JumpAdress();
        return uniqueInstance;
    }




    
}
