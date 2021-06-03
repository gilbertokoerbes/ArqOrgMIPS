public class Codifica {

    String opcode;
    String rs;
    String rt;
    String rd;
    String imm;
    public void Codificador (String line){//recebe a linha basic e direciona para o metodo codificador correspondente
        this.opcode = ""   ;
        this.rs     = ""   ;
        this.rt     = ""   ;
        this.rd     = ""   ; 
        this.imm    = ""   ;   
        String[] line1 = line.split(" ");
        String opCode = line1[0]; // recebe o opmode lido da linha
        String newLine="";
        for(int i=1; i<line1.length;i++){//juntar o restante de line1 sem os espaços
            newLine+=line1[i];
        }
        System.out.println("opCode = " + opCode);
        System.out.println("newline = " + newLine);
        switch(opCode){
            case "j":
                type_J(newLine);
                break;
            case "jr":
                type_JR(newLine);
                break;
            case "add":
                String[] lineAdd = newLine.split(",");
                type_R(opCode, lineAdd[0], lineAdd[1], lineAdd[2]);
                break;                
            case "and":                
                String[] lineAnd = newLine.split(",");
                type_R(opCode, lineAnd[0], lineAnd[1], lineAnd[2]);
                break;
            case "srl":
                String[] lineSrl = newLine.split(",");
                type_SRL(opCode, lineSrl[0], lineSrl[1], lineSrl[2]);
                break;
            case "slti":
                String[] lineSlti = newLine.split(",");
                System.out.println("Parametros passados = "+ opCode +" "+ lineSlti[0]+" "+ lineSlti[1]+" "+ lineSlti[2]);
                type_I(opCode, lineSlti[0], lineSlti[1], lineSlti[2]);
                break;
            case "ori":
                String[] lineOri = newLine.split(",");
                type_I(opCode, lineOri[0], lineOri[1], lineOri[2]);
                break;
            case "beq":
                String[] lineBeq = newLine.split(",");
                type_I(opCode, lineBeq[0], lineBeq[1], lineBeq[2]);
                break;
            case "bne":
                String[] lineBnq = newLine.split(",");
                type_I(opCode, lineBnq[0], lineBnq[1], lineBnq[2]);
                break;
            default:
                System.out.println("DEFAULT: BREAK");
                break;
            

                
                            

        }
            

    }

    public void type_R(String opcode, String rd, String rs, String rt) {
        this.opcode = opcode;
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;

        String func = "";
        String shamt;

        Registradores reg = new Registradores();
        //System.out.println("type R ok = " + rs);
        /*System.out.println("Saida rt = " + rt);
        System.out.println("Saida rd = " + rd);*/
            // binario <-- int (String) <-- $registrador
            rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)
            rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)
            rd = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rd, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)

            // A função toBinaryString desconsidera o primeiro 0, caso não precise para
            // converter o número
            // Para, isso foi feito uma verificação para forçar a manter os 5 bits
            // obrigatórios por registrador
            // Ex: 8 em 5 bits == 01000 => aqui ele desconsidera o primeiro zero
            while (rs.length() < 5)
                rs = "0" + rs;
            while (rt.length() < 5)
                rt = "0" + rt;
            while (rd.length() < 5)
                rd = "0" + rd;

            /*System.out.println("Saida rs = " + rs);
            System.out.println("Saida rt = " + rt);
            System.out.println("Saida rd = " + rd);*/

            if (opcode.equalsIgnoreCase("and"))
                func = "100100";
            ; // valor direto em binario, referente ao valor func "0x20" da instrução add (6
              // BITS)
            if (opcode.equalsIgnoreCase("add"))
                func = "100000";
            // if(opcode.equals("srl")) func = "000010"; //???????????????????

            opcode = "000000"; // valor direto em binario, referente ao opcode "0" da instrução add (6 BITS)
            shamt = "00000"; // valor direto em binario, referente ao valor shamt "0" da instrução add (5
                             // BITS)

            String bin = opcode + rs + rt + rd + shamt + func;

            String binAux = "0x";

            for (int i = 0; i < bin.length(); i += 4) {
                /*System.out.println("Saida LOOP = " + i);*/
                binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
            }
            System.out.println("Saida concatena = " + binAux + "\n");

        
    }

    // Um registrador fonte, um registrador operando, e um número
    public void type_I(String opcode, String rt, String rs, String imm) {
        System.out.println("Parametros Recebidos = "+ opcode +" "+ rt+" "+ rs+" "+ imm);
        this.opcode = opcode;
        this.rs = rs;
        this.rt = rt;
        this.imm = imm; // 16 bits
        String opcodeBkp = opcode; // utilizado para manter o tipo de entrada "ori, slti, beq"

        Registradores reg = new Registradores();
        /*System.out.println("Saida rs = " + rs);
        System.out.println("Saida rt = " + rt);
        System.out.println("Saida rd = " + rd);*/

            if (opcode.equalsIgnoreCase("ori"))  opcode = "1101"; // 0xd | 13
            if (opcode.equalsIgnoreCase("slti")) opcode = "1010"; // 0xa | 10
            if (opcode.equals("beq")) opcode = "0100";
            if (opcode.equals("bne")) opcode = "0101";
            //System.out.println("Opcode origin: "+ opcode);
            //if (opcode == "4" || opcode == "5") opcode = Integer.toBinaryString(Integer.parseInt(opcode, 16)); // 000100
            //if (opcode != "4") opcode = Integer.toBinaryString(Integer.parseInt(opcode,16));
            
            //System.out.println("opcode convertido" + opcode);
            while (opcode.length() < 6) opcode = "0" + opcode;
           
            //System.out.println("opcode: " + opcode);

            rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)
            rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)

            // Força a manter os 5 bits obrigatorios referente aos registradores
            while (rs.length() < 5)
                rs = "0" + rs;
            while (rt.length() < 5)
                rt = "0" + rt;

            // Recebe = "0x00000000"
            String[] immAux = imm.split("x");
            imm = "";
            imm = immAux[1];
            // Retorna == "00000000" sem o "0x"

            

            // Converte para binário

        
            //imm = Integer.toBinaryString(Integer.parseInt(imm, 16));
            imm = Long.toBinaryString(Long.parseUnsignedLong(imm, 16));
           
            //int immTeste = Integer.parseInt("ff00000f", 16);
            //System.out.println("Teste: "+ immTeste);
            //System.out.println("Valor bin:" + imm);

            // Força a manter os 16 bits obrigatorios referente ao immediate
            while (imm.length() < 16) {
                imm = "0" + imm;
            }            
            if(imm.length()>16) imm = imm.substring(imm.length()-16, imm.length());  
            System.out.println("Retorna:" + imm);       

            /*System.out.println("Valor imm:" + imm);
            System.out.println("Valor opcode:" + opcode);
            System.out.println("valor rs:" + rs);
            System.out.println("valor rt:" + rt);*/
            
            System.out.println(opcode + " "+rs +" "+ rt +" "+ imm);
            String bin = opcode + rs + rt + imm;
            if (opcodeBkp == "beq" || opcodeBkp == "bnq")
                bin = opcode + rt + rs + imm; // casos de branch são similares o tipo_I somente invertendo os
                                              // registrados de entrada
           System.out.println("\nBinario:" + bin);

            String binAux = "0x";

    
            for (int i = 0; i < bin.length(); i += 4) {
                System.out.println("Saida LOOP = " + i );
                binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
            }
            System.out.println("Saida concatenada = " + binAux);

        
    }

    public void type_SRL(String opcode, String rd, String rt, String shamtIn){
        this.opcode = opcode;
        this.rt = rt;
        this.rd = rd;
        String shamt = shamtIn;

        String func = "000010";
        

        Registradores reg = new Registradores();      
        //System.out.println("Saida rt = " + rt);
        //System.out.println("Saida rd = " + rd);

        
            // binario <-- int (String) <-- $registrador
            rd = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rd, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)
            rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt, 1))); // valor em binário referente ao
                                                                                   // registrador (5 BITS)
           
            // A função toBinaryString desconsidera o primeiro 0, caso não precise para
            // converter o número
            // Para, isso foi feito uma verificação para forçar a manter os 5 bits
            // obrigatórios por registrador
            // Ex: 8 em 5 bits == 01000 => aqui ele desconsidera o primeiro zero
            while (rt.length() < 5)
                rt = "0" + rt;
            while (rd.length() < 5)
                rd = "0" + rd;


            //System.out.println("Saida rt = " + rt);
            //System.out.println("Saida rd = " + rd);


            opcode = "000000"; // valor direto em binario, referente ao opcode "0" da instrução add (6 BITS)
            
            String[] shamtAux = shamt.split("x");
            shamt = "";
            shamt = shamtAux[1];

            shamt = Integer.toString(Integer.parseInt(shamt, 16), 2); // shamt de hexa passa para binario sem 0x

            while (shamt.length() < 5) // preenche shamt com 0
                shamt = "0" + shamt;
            
            String bin = opcode + "00000" + rt + rd + shamt + func;
            //System.out.println("Saida bin = " + bin + "\n");
            String binAux = "0x";

            for (int i = 0; i < bin.length(); i += 4) {
                //System.out.println("Saida LOOP = " + i);
                binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
            }
            System.out.println("Saida concatena = " + binAux + "\n");


    }

    public void type_J(String hex){
        opcode = "000010";

        String[] hexAux = hex.split("x");
        hex = "";
        hex = hexAux[1];
        
        hex = Integer.toString(Integer.parseInt(hex, 16), 2);       
        //System.out.println("Saida hex: "+ hex);

        while(hex.length() < 32) hex = "0" + hex;

        //System.out.println("Saida hex completa: "+ hex);
        hex = hex.substring(0+4, (hex.length()-2));
        String bin = opcode + hex;
        //System.out.println("Saida bin: " + bin);

        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {
            //System.out.println("Saida LOOP = " + i);
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }
        
        System.out.println("\nSaida concatenada j: " + binAux);

    }

    public void type_JR(String rs){
        Registradores reg = new Registradores();
        opcode = "000000";
        System.out.println("Rs recebido = " + rs+"|");
        System.out.println("Busca reg = " + reg.registerInt(rs, 1));

        rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs, 1)));
        
        while (rs.length() < 5) rs = "0" + rs;

        String bin = opcode + rs + "0000000000000000" + "01000";

        String binAux = "0x";
        
        for (int i = 0; i < bin.length(); i += 4) {
            //System.out.println("Saida LOOP = " + i);
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }

        System.out.println("\nSaida concatenada jr: " + binAux);
    }


}

/*
 * String bin = Integer.toString(Integer.parseInt("C2", 16), 2); // hex2bin
 * 
 * System.out.println("Hexa2bin:" + bin); String hexa =
 * Integer.toString(Integer.parseInt("1111", 2), 16); // bin2hex
 * System.out.println("Bin2Hex:" + hexa);
 */
