package com.company;

import java.util.HashMap;
import java.util.Map;

public class Registers {

    public String readRegister1; //utilizamos string para manter os 0's a esquerda 
    public String readRegister2; //utilizamos string para manter os 0's a esquerda 
    public String writeRegister; //utilizamos string para manter os 0's a esquerda 
    public String writeData ="";

    public String readData1;
    public String readData2;

    public String regWrite = Control.getInstance().RegWrite;


    public void execute(){ //executa quando contem os parametros necessário (dipapardo por PreMuxRegister)
        System.out.println("\n------------------ Entrou no Registers ------------------");
        System.out.println("          - Valor readRegister1 = "+readRegister1);
        System.out.println("          - Valor readRegister2 = "+readRegister2);
        System.out.println("          - Valor WriteRegister = "+writeRegister);
        System.out.println("          - Valor WriteData = "+writeData);
        // Já recebeu os sinais de instrução
        readData1 = RegisterDisplay.get(Integer.toString(Integer.parseInt(readRegister1, 2)));//obtem o valor 'data'que está no registrador (Convter binario para chave de busca)
        readData2 = RegisterDisplay.get(Integer.toString(Integer.parseInt(readRegister2, 2)));  
        outPuts(readData1, readData2);//encaminha para os sinais de saida     
    }

    public void outPuts(String rdData1, String rdData2){

        System.out.println("          - Valor Output ReadData1 = "+readData1);
        System.out.println("          - Valor Output ReadData2 = "+readData2);
        ALU.getInstance().inputRegisters = rdData1;        
        PreMuxAlu.getInstance().Mux0 = rdData2;
        //PreMuxAlu.getInstance().selectMux();

    }

    //sera disparado pelo ultimo mux apos alu, escrevendo o dado no registrador
    public void saveDataRegister(String inputData){ 
        this.writeData = inputData;
        if(regWrite.equalsIgnoreCase("1")){ //se regWrite ativado permite escrita
            writeRegister = Integer.toString(Integer.parseInt(writeRegister, 2));
            RegisterDisplay.replace(writeRegister, writeData); //altera no Registro o valor data recebido
        }
    }



    public Map<String,String> RegisterDisplay = new HashMap<String,String>(); 
    public void registerInt(){                     
        RegisterDisplay.put("0","0");
        RegisterDisplay.put("1","0");
        RegisterDisplay.put("2","0");
        RegisterDisplay.put("3","0");
        RegisterDisplay.put("4","0");
        RegisterDisplay.put("5","0");
        RegisterDisplay.put("6","0");
        RegisterDisplay.put("7","0");
        RegisterDisplay.put("8","0");
        RegisterDisplay.put("9","0");
        RegisterDisplay.put("10","0");
        RegisterDisplay.put("11","0");
        RegisterDisplay.put("12","0");
        RegisterDisplay.put("13","0");
        RegisterDisplay.put("14","0");
        RegisterDisplay.put("15","0");
        RegisterDisplay.put("16","0");
        RegisterDisplay.put("17","0");
        RegisterDisplay.put("18","0");
        RegisterDisplay.put("19","0");
        RegisterDisplay.put("20","0");
        RegisterDisplay.put("21","0");
        RegisterDisplay.put("22","0");
        RegisterDisplay.put("23","0");
        RegisterDisplay.put("24","0");
        RegisterDisplay.put("25","0");
        RegisterDisplay.put("26","0");
        RegisterDisplay.put("27","0");
        RegisterDisplay.put("28","268468224");
        RegisterDisplay.put("29","2147479548");
        RegisterDisplay.put("30","0");
        RegisterDisplay.put("31","0");
    }


    //Singleton
    private static Registers uniqueInstance;
    
    private Registers() {
        registerInt();//Inicia os registradores
    }

    public static synchronized Registers getInstance() {
       
        if (uniqueInstance == null)
            uniqueInstance = new Registers();
        return uniqueInstance;
    }
    
}
