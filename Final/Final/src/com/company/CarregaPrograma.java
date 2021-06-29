package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CarregaPrograma {

    public void carregaInstrucoes() {
        String fName = "instrucoes.txt"; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\IO\\" + fName;
        Path path = Paths.get(nameComplete);        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                //carrega ja na memoria de instruções
                InstructionMemory.getInstance().CarregarInstrucoes(linha);               
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
