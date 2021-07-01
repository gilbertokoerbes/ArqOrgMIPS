package com.company;

public class ALU {

    public String inputRegisters;
    public String inputPreMuxAlu;
    public String opMode_AluControl;
    public String outputALU;
    public int result, cont_aux=0;
    public boolean output_zero = false;

    //Verifica a operação e desenvolve ela   
    public void set_op_ALU(){
         opMode_AluControl = AluControl.getInstance().output_AluControl;

        System.out.println("Entrei set_op_ALU");
        System.out.println("Valor opMode_ALUControl (Vindo da saída do AluControl): " + opMode_AluControl);
        System.out.println("Valor inputRegisters (Vindo da saída do Registers): " + inputRegisters);
        System.out.println("inputPreMuxAlu (Vindo da saída do PreMuxAlu): " + inputPreMuxAlu);

        if(opMode_AluControl.equals("000")){  //add
            int r1=0, r2=0;

            for (int i=0, j=inputRegisters.length()-1;i<inputRegisters.length();i++,j--) {
                if(inputRegisters.charAt(j) == '1') {
                    r1 = (int) (r1 + Math.pow(2, i));
                }
            }
            for (int i=0, j=inputPreMuxAlu.length()-1;i<inputPreMuxAlu.length();i++,j--) {
                if(inputPreMuxAlu.charAt(j) == '1') {
                    r2 = (int) (r2 + Math.pow(2, i));
                }
            }            
            result = r1+r2;
            this.outputALU = Integer.toBinaryString(result);
            //System.out.println(outputALU);
            
            //Verifica se o output da zero, para transformar o outro output em true
            for(int i=0;i<outputALU.length();i++){
                if(outputALU.charAt(0) == '0'){
                    cont_aux++;
                }
            }
            if(cont_aux == outputALU.length()){
                this.output_zero = true;
            }


        }
        else if(opMode_AluControl.equals("001")){ // Sub
            int r1=0, r2=0;
            for (int i=0, j=inputRegisters.length()-1;i<inputRegisters.length();i++,j--) {
                if(inputRegisters.charAt(j) == '1') {
                    r1 = (int) (r1 + Math.pow(2, i));
                }
            }

            for (int i=0, j=inputPreMuxAlu.length()-1;i<inputPreMuxAlu.length();i++,j--) {
                if(inputPreMuxAlu.charAt(j) == '1') {
                    r2 = (int) (r2 + Math.pow(2, i));
                }
            }

            this.result = r1-r2;
            this.outputALU = Integer.toBinaryString(result);
            //System.out.println(outputALU);

            //Verifica se o output da zero, para transformar o outro output em true
            for(int i=0;i<outputALU.length();i++){
                if(outputALU.charAt(0) == '0'){
                    this.cont_aux++;
                }
            }
            if(cont_aux == outputALU.length()){
                this.output_zero = true;
            }
        }
        else if(opMode_AluControl.equals("010")){ // And
            for(int i=0; i<inputRegisters.length();i++){
                if(inputRegisters.charAt(i) == '0'|| inputPreMuxAlu.charAt(i) == '0'){
                    this.outputALU += "0";
                }
                else {
                    this.outputALU = outputALU.concat("1");
                }
            }
            //System.out.println(outputALU);

            //Verifica se o output da zero, para transformar o outro output em true
            for(int i=0;i<outputALU.length();i++){
                if(outputALU.charAt(0) == '0'){
                    this.cont_aux++;
                }
            }
            if(cont_aux == outputALU.length()){
                this.output_zero = true;
            }
        }
        else if(opMode_AluControl.equals("011")){ // Or
            for(int i=0; i<inputRegisters.length();i++){
                if(inputRegisters.charAt(i) == '0'&& inputPreMuxAlu.charAt(i) == '0'){
                    this.outputALU = outputALU.concat("0");
                }
                else {
                    this.outputALU = outputALU.concat("1");
                }
            }
            //System.out.println(outputALU);

            //Verifica se o output da zero, para transformar o outro output em true
            for(int i=0;i<outputALU.length();i++){
                if(outputALU.charAt(0) == '0'){
                    this.cont_aux++;
                }
            }
            if(cont_aux == outputALU.length()){
                this.output_zero = true;
            }
        }

        /*else if(opMode_AluControl.equals("100")){ // Not
        }
        else if(opMode_AluControl.equals("101")){
            opMode_AluControl = "ShiftLeft";
        }
        else if(opMode_AluControl.equals("110")){
            opMode_AluControl = "ShiftRight";
        }*/

        System.out.println("Valor outputALU saindo: "+outputALU);
        System.out.println("Saindo do Método set_op_ALU");
    }

    private static ALU uniqueInstance;
    
    private ALU() {

    }

    public static synchronized ALU getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ALU();
        return uniqueInstance;
    }     

} 
