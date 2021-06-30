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
        // Já recebeu os sinais de instrução
        readData1 = RegisterDisplay.get(Integer.toString(Integer.parseInt(readRegister1, 2)));//obtem o valor 'data'que está no registrador (Convter binario para chave de busca)
        readData2 = RegisterDisplay.get(Integer.toString(Integer.parseInt(readRegister2, 2)));  
        outPuts(readData1, readData2);//encaminha para os sinais de saida     
    }

    public void outPuts(String rdData1, String rdData2){
        ALU.getInstance().inputRegisters = rdData1;
        
        PreMuxAlu.getInstance().Mux0 = rdData2;
        PreMuxAlu.getInstance().selectMux();

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
        RegisterDisplay.put("0","$0");
        RegisterDisplay.put("1","$1");
        RegisterDisplay.put("2","$2");
        RegisterDisplay.put("3","$3");
        RegisterDisplay.put("4","$4");
        RegisterDisplay.put("5","$5");
        RegisterDisplay.put("6","$6");
        RegisterDisplay.put("7","$7");
        RegisterDisplay.put("8","$8");
        RegisterDisplay.put("9","$9");
        RegisterDisplay.put("10","$10");
        RegisterDisplay.put("11","$11");
        RegisterDisplay.put("12","$12");
        RegisterDisplay.put("13","$13");
        RegisterDisplay.put("14","$14");
        RegisterDisplay.put("15","$15");
        RegisterDisplay.put("16","$16");
        RegisterDisplay.put("17","$17");
        RegisterDisplay.put("18","$18");
        RegisterDisplay.put("19","$19");
        RegisterDisplay.put("20","$20");
        RegisterDisplay.put("21","$21");
        RegisterDisplay.put("22","$22");
        RegisterDisplay.put("23","$23");
        RegisterDisplay.put("24","$24");
        RegisterDisplay.put("25","$25");
        RegisterDisplay.put("26","$26");
        RegisterDisplay.put("27","$27");
        RegisterDisplay.put("28","$28");
        RegisterDisplay.put("29","$29");
        RegisterDisplay.put("30","$30");
        RegisterDisplay.put("31","$31");
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
