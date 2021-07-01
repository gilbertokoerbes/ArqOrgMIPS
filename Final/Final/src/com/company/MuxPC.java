package com.company;

public class MuxPC {

    public int addPC0; //recebe
    public int addPC1; //recebe
    public String pcSrc; //recebe
    public int MuxPCOut; //sai

    public void selectMuxPC(){
        addPC0 = AddPC.getInstance().add;
        addPC1 = AddPC2.getInstance().AddPC2Result;
        pcSrc = PCSrcAND.getInstance().PCSrcOut;


        if (pcSrc.equalsIgnoreCase("0")) MuxPCOut = addPC0;
        else if(pcSrc.equalsIgnoreCase("1")) MuxPCOut = addPC1;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");
    }




    private static MuxPC uniqueInstance;

    private MuxPC() {
    }

    public static synchronized MuxPC getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new MuxPC();
        return uniqueInstance;
    }
    
}
