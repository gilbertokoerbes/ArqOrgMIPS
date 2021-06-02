public class Codifica {
    
    String opmode;
    String rs;
    String rt;
    String rd;
    String imm;

    public void type_R(String opmode, String rd, String rs, String rt){
        this.opmode = opmode;
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
        
        String func="";
        String shamt;

        Registradores reg = new Registradores();  
        System.out.println("Saida rs = " + rs);
        System.out.println("Saida rt = " + rt);
        System.out.println("Saida rd = " + rd); 
    

        if(opmode=="add" || opmode=="and"){
            //            binario      <-- int (String)      <-- $registrador  
            rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs,1))); // valor em binário referente ao registrador (5 BITS)
            rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt,1))); // valor em binário referente ao registrador (5 BITS)
            rd = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rd,1))); // valor em binário referente ao registrador (5 BITS)
            
            //A função toBinaryString desconsidera o primeiro 0, caso não precise para converter o número
            // Para, isso foi feito uma verificação para forçar a manter os 5 bits obrigatórios por registrador
            //Ex: 8 em 5 bits == 01000  => aqui ele desconsidera o primeiro zero
            if (rs.length()<5) rs="0"+rs;
            if (rt.length()<5) rt="0"+rt;
            if (rd.length()<5) rd="0"+rd;

            System.out.println("Saida rs = " + rs);
            System.out.println("Saida rt = " + rt);
            System.out.println("Saida rd = " + rd);

            if(opmode.equals("and")) func = "100100";; // valor direto em binario, referente ao valor func "0x20" da instrução add (6 BITS)
            if(opmode.equals("add")) func = "100000";
            if(opmode.equals("srl")) func = "100000"; //???????????????????

            opmode = "000000"; // valor direto em binario, referente ao opmode "0" da instrução add (6 BITS)
            shamt = "00000"; // valor direto em binario, referente ao valor shamt "0" da instrução add (5 BITS)

            String bin = opmode +rs + rt + rd + shamt + func;

            String binAux="0x";

            for(int i=0; i<bin.length(); i+=4){
                System.out.println("Saida LOOP = " + i );
                binAux += Integer.toString(Integer.parseInt(bin.substring(i, i+4), 2), 16); // bin2hex
            }
            System.out.println("Saida concatena = " + binAux);

        }
    }


    public void type_I(String opmode, String rt, String rs, String imm){
        this.opmode = opmode;
        this.rs = rs;
        this.rt = rt;
        this.imm = imm;
        
        String func="";
        String shamt;

        Registradores reg = new Registradores();  
        System.out.println("Saida rs = " + rs);
        System.out.println("Saida rt = " + rt);
        System.out.println("Saida rd = " + rd); 

        if(opmode == "ori"){
            opmode = "0xd00000";
            rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs,1))); // valor em binário referente ao registrador (5 BITS)
            rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt,1))); // valor em binário referente ao registrador (5 BITS)

            


        }
    }

}



        /*String bin = Integer.toString(Integer.parseInt("C2", 16), 2); // hex2bin

        System.out.println("Hexa2bin:" + bin);
        String hexa = Integer.toString(Integer.parseInt("1111", 2), 16); // bin2hex
       System.out.println("Bin2Hex:" + hexa);*/


    
    



  

