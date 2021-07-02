package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class CarregaPrograma {

    public void carregaInstrucoes() {
        System.out.println("\n------------------ Entrou no Carrega Instruções ------------------" );
        System.out.println("                    * Lendo Arquivo Entrada... *" );
        String fName = "instrucoes.txt"; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        System.out.println("          - Diretório atual = " + currDir);
        String nameComplete = currDir + "\\IO\\" + fName;
        Path path = Paths.get(nameComplete);        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) { //Converte a instrução decodificado em string com binário
                String linha = sc.nextLine();
                String input = linha;
                String[] hexAux;      
                hexAux = input.split("x");
                input = hexAux[1];      
                String input2bin = "";
                for (int i = 0; i < 8; i++) { // -> pega um caractere da entrda, tranforma em numerico hexa, e de hexa para
                                              // binario      
                     String binIntermediario = Integer.toString(Integer.parseInt(input.substring(i, i + 1), 16), 2);
                     while (binIntermediario.length() < 4) binIntermediario = "0" + binIntermediario; // completa o resultado com zeros. Ex: 0 -> 0000
                    input2bin += binIntermediario;
                }


                //carrega ja na memoria de instruções
                System.out.println("          - Valor de instrução gravado = " + input2bin);
                InstructionMemory.getInstance().CarregarInstrucoes(input2bin);               
            }

        }            
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    
    }


    private static CarregaPrograma uniqueInstance;
    
    private CarregaPrograma() {
    }

    public static synchronized CarregaPrograma getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new CarregaPrograma();
        return uniqueInstance;
    }
}
