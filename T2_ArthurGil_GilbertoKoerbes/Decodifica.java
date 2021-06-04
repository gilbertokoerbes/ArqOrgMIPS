import java.util.ArrayList;
import java.util.Map;

public class Decodifica {
     Registradores reg = new Registradores();

     ArrayList<String> retornoDecodifica;

     public Decodifica() {
          retornoDecodifica = new ArrayList<>();
     }

     public ArrayList<String> retornaDecodifiList() {
          return retornoDecodifica;
     }

     public void DecodificaInput(String lineInput) {
          String input = lineInput;
          String[] hexAux;

          hexAux = input.split("x");
          input = hexAux[1];

          String input2bin = "";
          for (int i = 0; i < 8; i++) { // -> pega um caractere da entrda, tranforma em numerico hexa, e de hexa para
                                        // binario

               String binIntermediario = Integer.toString(Integer.parseInt(input.substring(i, i + 1), 16), 2);
               while (binIntermediario.length() < 4)
                    binIntermediario = "0" + binIntermediario; // completa o resultado com zeros. Ex: 0 -> 0000
                    input2bin += binIntermediario;
          }
          
          String input2binOpCode = input2bin.substring(0, 6);
          String input2binFunc = input2bin.substring(input2bin.length() - 6, input2bin.length());

          // Realiza uma espécie de "switch", que verifica qual instrução vai ser executada através 
          // dos valores de opcode e func, que, em muitos casos, é o diferencial de uma instrução para outra
        
          if (input2binOpCode.equalsIgnoreCase("000000")) {
               if (input2binFunc.equalsIgnoreCase("001000"))
                    decodeJr(input2bin); // jump register jr rs
               if (input2binFunc.equalsIgnoreCase("100000"))
                    decodeAdd(input2bin); // Add
               if (input2binFunc.equalsIgnoreCase("000010"))
                    decodeSrl(input2bin); // Srl
               if (input2binFunc.equalsIgnoreCase("100100"))
                    decodeAnd(input2bin); // and

          } else if (input2binOpCode.equalsIgnoreCase("000010"))
               decodeJump(input2bin);
          else // Jump

          if (input2binOpCode.equalsIgnoreCase("001010"))
               decodeSlti(input2bin);
          else // slti

          if (input2binOpCode.equalsIgnoreCase("100011"))
               decodeLw(input2bin);
          else // lw

          if (input2binOpCode.equalsIgnoreCase("001101"))
               decodeOri(input2bin);
          else // ori

          if (input2binOpCode.equalsIgnoreCase("000100"))
               decodeBeq(input2bin);
          else // beq

          if (input2binOpCode.equalsIgnoreCase("000101"))
               decodeBne(input2bin); // bne
     }

     /*
          *************
          A partir daqui, é gerado a saída de todas as instruções, apenas pegando os bits corretos referente a cada 
          valor correspondente à instrução.
          É feito também, conversões de binário para hexadecimal e também para string

          *************
     */


     public void decodeJump(String line) {

          String opcode = "j";
          String target = line.substring(line.length() - 26, line.length());
          while(target.length()<26) target="0"+target;
          target = "0000"+target+"00";
          String targetHex = Integer.toString(Integer.parseInt(target, 2), 16); 

          String saida = opcode + " " + "0x" + targetHex;
          retornoDecodifica.add(saida);
         
     }

     public void decodeAdd(String line) {

          String opcode = "add";
          String func = "0x20";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
         

          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
          

          String rd = line.substring(line.length() - 16, line.length() - 11);
          rd = Integer.toString(Integer.parseInt(rd, 2));
          rd = reg.register(rd, "0");
          
          //
          String hex = opcode + " " + rd + "," + " " + rs + "," + " " + rt;
          retornoDecodifica.add(hex);
          
     }

     public void decodeAnd(String line) {
          String opcode = "and";
          String func = "0x24";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
          
          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
          
          String rd = line.substring(line.length() - 16, line.length() - 11);
          rd = Integer.toString(Integer.parseInt(rd, 2));
          rd = reg.register(rd, "0");
          
          String hex = opcode + " " + rd + "," + " " + rs + "," + " " + rt;
          retornoDecodifica.add(hex);
          
     }

     public void decodeOri(String line) {
          String opcode = "ori";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
         
          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
          
          String imm = line.substring(line.length() - 16, line.length());
          imm = Integer.toString(Integer.parseInt(imm, 2));
          
          String hex = opcode + " " + rt + "," + " " + rs + "," + " " + imm;
          retornoDecodifica.add(hex);
          
     }

     public void decodeSrl(String line) {
          String opcode = "srl";

          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
          
          String rd = line.substring(line.length() - 16, line.length() - 11);
          rd = Integer.toString(Integer.parseInt(rd, 2));
          rd = reg.register(rd, "0");
          
          String shamt = line.substring(line.length() - 11, line.length() - 6);
          shamt = Integer.toString(Integer.parseInt(shamt, 2));
          
          String hex = opcode + " " + rd + "," + " " + rt + "," + " " + shamt;
          retornoDecodifica.add(hex);
          
     }

     public void decodeSlti(String line) {
          String opcode = "slti";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
          
          String rd = line.substring(line.length() - 21, line.length() - 16);
          rd = Integer.toString(Integer.parseInt(rd, 2));
          rd = reg.register(rd, "0");

          String imm = line.substring(line.length() - 16, line.length());
          imm = Integer.toString(Integer.parseInt(imm, 2));

          String hex = opcode + " " + rd + "," + " " + rs + "," + " " + imm;
          retornoDecodifica.add(hex);
          
     }

     public void decodeLw(String line) {
          String opcode = "lw";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");

          String rd = line.substring(line.length() - 21, line.length() - 16);
          rd = Integer.toString(Integer.parseInt(rd, 2));
          rd = reg.register(rd, "0");
          
          String offset = line.substring(line.length() - 16, line.length());
          offset = Integer.toString(Integer.parseInt(offset, 2));
          
          String hex = opcode + " " + rd + "," + " " + offset + "(" + rs + ")";
          retornoDecodifica.add(hex);
         
     }

     public void decodeJr(String line) {
          String opcode = "jr";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
          
          String hex = opcode + " " + rs;
          retornoDecodifica.add(hex);
          
     }

     public void decodeBeq(String line) {
          String opcode = "beq";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");
          
          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
          
          String offset = line.substring(line.length() - 16, line.length());
          
          offset = Long.toString(Long.parseLong(offset, 2), 16);

          if (offset.contains("fff"))
               while (offset.length() < 8)
                    offset = "f" + offset;

          String hex = opcode + " " + rs + "," + " " + rt + "," + " " + "0x" + offset;
          retornoDecodifica.add(hex);
          

     }

     public void decodeBne(String line) {
          String opcode = "bne";

          String rs = line.substring(line.length() - 26, line.length() - 21);
          rs = Integer.toString(Integer.parseInt(rs, 2));
          rs = reg.register(rs, "0");

          String rt = line.substring(line.length() - 21, line.length() - 16);
          rt = Integer.toString(Integer.parseInt(rt, 2));
          rt = reg.register(rt, "0");
       
          String offset = line.substring(line.length() - 16, line.length());
          offset = Long.toString(Long.parseLong(offset, 2), 16);

          if (offset.contains("fff"))
               while (offset.length() < 8)
                    offset = "f" + offset;
         
          String hex = opcode + " " + rs + "," + " " + rt + "," + " " + "0x" + offset;
          retornoDecodifica.add(hex);
          
     }

}
