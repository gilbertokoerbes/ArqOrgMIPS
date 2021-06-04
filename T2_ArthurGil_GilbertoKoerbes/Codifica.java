import java.util.ArrayList;

public class Codifica {

    String opcode;
    String rs;
    String rt;
    String rd;
    String imm;
    ArrayList<String> retornoCodifica;

    public Codifica() {
        retornoCodifica = new ArrayList<>();
    }

    public ArrayList<String> retornaCodificaList() {
        return retornoCodifica;
    }

    public void CodificadorInput(String line) {// recebe a linha basic e direciona para o metodo codificador
                                               // correspondente
        this.opcode = "";
        this.rs = "";
        this.rt = "";
        this.rd = "";
        this.imm = "";

        String[] line1 = line.split(" ");
        String opCode = line1[0]; // recebe o opmode lido da linha
        String newLine = "";

        for (int i = 1; i < line1.length; i++) {// juntar o restante de line1 sem os espaços
            newLine += line1[i];
        }
    
        switch (opCode) {
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
                type_I(opCode, lineSlti[0], lineSlti[1], lineSlti[2]);
                break;

            case "ori":
                String[] lineOri = newLine.split(",");
                type_I(opCode, lineOri[0], lineOri[1], lineOri[2]);
                break;

            case "lw":
                String[] lineLw = newLine.split(",");
                type_I(opCode, lineLw[0], "0", lineLw[1]);
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

        if (opcode.equalsIgnoreCase("and"))
            func = "100100";
        // valor direto em binario, referente ao valor func "0x20" da instrução add (6 BITS)
        if (opcode.equalsIgnoreCase("add"))
            func = "100000";

        opcode = "000000"; // valor direto em binario, referente ao opcode "0" da instrução add (6 BITS)
        shamt = "00000"; // valor direto em binario, referente ao valor shamt "0" da instrução add (5 BITS)

        String bin = opcode + rs + rt + rd + shamt + func;
        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {

            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }
        retornoCodifica.add(binAux);
        //System.out.println("Saida concatenada = " + binAux + "\n");

    }

    // Um registrador fonte, um registrador operando, e um número
    public void type_I(String opcode, String rt, String rs, String imm) {// imm ou offset

        this.opcode = opcode;
        this.rs = rs;
        this.rt = rt;
        this.imm = imm; // 16 bits
        String opcodeBkp = opcode; // utilizado para manter o tipo de entrada "ori, slti, beq"

        Registradores reg = new Registradores();

        if (opcode.equalsIgnoreCase("ori"))
            opcode = "1101"; // 0xd | 13
        if (opcode.equalsIgnoreCase("slti"))
            opcode = "1010"; // 0xa | 10
        if (opcode.equalsIgnoreCase("beq"))
            opcode = "0100";
        if (opcode.equalsIgnoreCase("bne"))
            opcode = "0101";
        if (opcode.equalsIgnoreCase("lw"))
            opcode = "100011";

        // if (opcode == "4" || opcode == "5") opcode =
        // Integer.toBinaryString(Integer.parseInt(opcode, 16)); // 000100
        // if (opcode != "4") opcode =
        // Integer.toBinaryString(Integer.parseInt(opcode,16));

        while (opcode.length() < 6)
            opcode = "0" + opcode;

        // Força a manter os 5 bits obrigatorios referente aos registradores

        // Recebe = "0x00000000"
        if (!opcodeBkp.equalsIgnoreCase("lw")) {
            String[] immAux = imm.split("x");
            imm = "";
            imm = immAux[1];
            // Retorna == "00000000" sem o "0x"

        } else { // pega lw, quebra offset e pega o registrador

            String[] immAux = imm.split("x");
            imm = "";
            imm = immAux[1];
            imm = imm.replaceAll("\\(", " ");
            imm = imm.replaceAll("\\)", "");
            immAux = imm.split(" ");
            imm = immAux[0];
            rs = immAux[1];
        }

        rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs, 1))); // valor em binário referente ao
                                                                               // registrador (5 BITS)
        rt = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rt, 1))); // valor em binário referente ao
                                                                               // registrador (5 BITS)

        while (rs.length() < 5)
            rs = "0" + rs;
        while (rt.length() < 5)
            rt = "0" + rt;

        // Converte para binário
 
        imm = Long.toBinaryString(Long.parseUnsignedLong(imm, 16));

        // Força a manter os 16 bits obrigatorios referente ao immediate
        while (imm.length() < 16) {
            imm = "0" + imm;
        }

        if (imm.length() > 16)
            imm = imm.substring(imm.length() - 16, imm.length());
        
        String bin = opcode + rs + rt + imm;

        if (opcodeBkp.equalsIgnoreCase("beq") || opcodeBkp.equalsIgnoreCase("bne"))
            bin = opcode + rt + rs + imm; // casos de branch são similares o tipo_I somente invertendo os
                                          // registrados de entrada
        

        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {
            
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }

        //System.out.println("Saida concatenada = " + binAux);
        retornoCodifica.add(binAux);

    }

    public void type_SRL(String opcode, String rd, String rt, String shamtIn) {
        this.opcode = opcode;
        this.rt = rt;
        this.rd = rd;
        String shamt = shamtIn;

        String func = "000010";

        Registradores reg = new Registradores();
       

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


        opcode = "000000"; // valor direto em binario, referente ao opcode "0" da instrução add (6 BITS)

        String[] shamtAux = shamt.split("x");
        shamt = "";
        shamt = shamtAux[1];

        shamt = Integer.toString(Integer.parseInt(shamt, 16), 2); // shamt de hexa passa para binario sem 0x

        while (shamt.length() < 5) // preenche shamt com 0
            shamt = "0" + shamt;

        String bin = opcode + "00000" + rt + rd + shamt + func;
        
        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {
            
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }
        //System.out.println("Saida concatena = " + binAux + "\n");
        retornoCodifica.add(binAux);

    }

    public void type_J(String hex) {
        opcode = "000010";

        String[] hexAux = hex.split("x");
        hex = "";
        hex = hexAux[1];

        hex = Integer.toString(Integer.parseInt(hex, 16), 2);
        

        while (hex.length() < 32)
            hex = "0" + hex;

        hex = hex.substring(0 + 4, (hex.length() - 2));
        String bin = opcode + hex;
        
        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {
            
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }

        //System.out.println("\nSaida concatenada j: " + binAux);
        retornoCodifica.add(binAux);

    }

    public void type_JR(String rs) {
        Registradores reg = new Registradores();
        opcode = "000000";
      
        rs = Integer.toBinaryString(Integer.parseInt(reg.registerInt(rs, 1)));

        while (rs.length() < 5)
            rs = "0" + rs;

        String bin = opcode + rs + "0000000000000000" + "01000";

        String binAux = "0x";

        for (int i = 0; i < bin.length(); i += 4) {
           
            binAux += Integer.toString(Integer.parseInt(bin.substring(i, i + 4), 2), 16); // bin2hex
        }

        //System.out.println("\nSaida concatenada jr: " + binAux);
        retornoCodifica.add(binAux);
    }

}
