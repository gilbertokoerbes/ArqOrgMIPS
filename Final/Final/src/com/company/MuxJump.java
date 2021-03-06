package com.company;

public class MuxJump {

    public String muxJumpString; //recebe
    public int Add2; //recebe
    public int MuxJump; //sai
    public int muxJumpOut;

    public void selectMuxPC(){
        System.out.println("\n------------------ Entrou no MuxJump ------------------");

        Add2 = MuxPC.getInstance().MuxPCOut;
        MuxJump = JumpAdress.getInstance().JumpCalculado;
        muxJumpString = PCSrcAND.getInstance().PCSrcOut;

        if (muxJumpString.equalsIgnoreCase("0")) muxJumpOut = Add2;
        else if(muxJumpString.equalsIgnoreCase("1")) muxJumpOut = MuxJump;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");

        System.out.println("          - Valor Input muxJumpString = "+muxJumpString);
        System.out.println("          - Valor Input Add2 = "+Add2);
        System.out.println("          - Valor Muxout = " +muxJumpOut);
        //PC.getInstance().nextExecution(muxJumpOut);
    }

    private static MuxJump uniqueInstance;
    
    private MuxJump() {
    }

    public static synchronized MuxJump getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new MuxJump();
        return uniqueInstance;
    }
    
}
