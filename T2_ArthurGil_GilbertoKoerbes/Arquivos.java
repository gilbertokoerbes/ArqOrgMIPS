import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Arquivos {
    
    ArrayList<String> retorno;
    

    public Arquivos() {
        retorno = new ArrayList<>();
    }
    
    public void carregaCodificador() {
        Codifica cod = new Codifica();
        String fName = "InputCodificador.asm"; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\IO\\" + fName;
        Path path = Paths.get(nameComplete);        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                cod.CodificadorInput(linha); 
            }
            retorno = cod.retornaCodificaList();

        }            
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
    public void salvaCode(){
		String fName = "ouputCodificacao.txt";
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\IO\\"+fName;
        Path path = Paths.get(nameComplete);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
          for(String r:retorno){ 
              System.out.println(r);              
                writer.println(r);
        }
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }        
    }

    public void carregaDecodificador() {
        Decodifica decod = new Decodifica();
        String fName = "InputDecodificador.txt"; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\IO\\" + fName;
        Path path = Paths.get(nameComplete);        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                decod.DecodificaInput(linha);; 
            }
            retorno = decod.retornaDecodifiList();

        }            
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
    public void salvaDecoode(){
        ArrayList<String> preGravacao = new ArrayList<>();
        int labelController = 0;
        Map<Integer,String> labels = new HashMap<Integer,String>(); 
        

		String fName = "OutputDecodificador.asm";
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\IO\\"+fName;
        Path path = Paths.get(nameComplete);

        for(String r:retorno){
            String reGravar= r;
            try {
                
                if(r.contains("j ")||r.contains("beq")||r.contains("bne")){
                    String[] label = r.split(" ");
                    reGravar="";
                    if(label[label.length-1].contains("ffff")){
                        label[label.length-1] = "main";
                        
                        for(int i=0;i<label.length;i++){
                        reGravar+=label[i]+" ";
                        }
                }else{

                        String[] newLabel = label[label.length-1].split("x");
                        
                        reGravar = newLabel[1];
                        
                        int hexa2dec = Integer.parseInt(reGravar);
                        System.out.println("valor hexa de label J = " + reGravar);
                        hexa2dec = hexa2dec - 400000;
                        System.out.println("Variação de label = "+ hexa2dec);
                        hexa2dec = Integer.parseInt(Integer.toString(hexa2dec),16);  
                       
                        String labelMap = "label"+Integer.toString(labelController);
                        labelController++;
                        System.out.println("label criada " + labelMap);
                        System.out.println("label cotrollet " +  labelMap);
                        labels.put((hexa2dec)/4, labelMap);
                        label[label.length-1] = labelMap;
                        reGravar="";
                        for(int i=0;i<label.length;i++){
                        reGravar+=" "+label[i];
                        
                        }
                        System.out.println("regravar de J = "+ reGravar);

                    }

                }    
        }catch (Exception e) {
            System.out.println("Erros de criação de label");
        }
        preGravacao.add(reGravar);
    }

       
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
            String base = ".text\n.globl main\nmain:";
            writer.print(base);
           
            for(int i =0; i<preGravacao.size(); i++){
                System.out.println(i+ " = " + preGravacao.get(i));
                for (int key : labels.keySet()) {
                    String value = labels.get(key);
                    if(preGravacao.get(i).contains(value)){
                        System.out.println("criando label para " + value);
                        System.out.println("linha que encotrou label " + preGravacao.get(i));
                        String preLabel = preGravacao.get(i+key);
                        System.out.println("linha a ser regravada " + preLabel);
                        preGravacao.add(i+key, value+": "+preLabel);
                        preGravacao.remove(i+key+1);  
                        labels.remove(key);
                    }
                }  
                           
            }
            
            System.out.println(" \nIniciando gravacao");
            for(int i =0; i<preGravacao.size(); i++){ 
                System.out.println(preGravacao.get(i));  
                if(!preGravacao.get(i).equalsIgnoreCase("label")||!preGravacao.get(i).equalsIgnoreCase("main")) 
                writer.println("        "+ preGravacao.get(i));else
                writer.println(preGravacao.get(i));
               // System.out.println(r);
               // writer.println(r);
            }

        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }        
    }


}
