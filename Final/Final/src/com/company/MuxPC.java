package com.company;

public class MuxPC {

    public int addPC0; //recebe
    public int addPC1; //recebe
    public String pcSrc; //recebe
    public int MuxPCOut; //sai

    public void selectMuxPC(){
        System.out.println("\n------------------ Entrou no MuxPC ------------------");
        addPC0 = AddPC.getInstance().add;
        addPC1 = AddPC2.getInstance().AddPC2Result;
        pcSrc = PCSrcAND.getInstance().PCSrcOut;

        System.out.println(pcSrc);
        if (pcSrc.equalsIgnoreCase("0")) MuxPCOut = addPC0;
        else if(pcSrc.equalsIgnoreCase("1")) MuxPCOut = addPC1;
        else System.out.println("SEM SELEÇÃO DE MUX Alu");

        System.out.println("          - Valor Input PC0 = "+addPC0);
        System.out.println("          - Valor Input PC1 = "+addPC1);
        System.out.println("          - Valor Input PCSrc = "+pcSrc);
        System.out.println("          - Valor Output = "+MuxPCOut);
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
