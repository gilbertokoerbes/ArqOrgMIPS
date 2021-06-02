public class Arquivos {
    /*

    public int[] carrega() {
        String fName = nameFile; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "\\Testes\\" + fName;
        Path path = Paths.get(nameComplete);

        int totalLinesFile = 0;  // total de linhas contadas no arquivo
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {

            while (sc.hasNext()) { // Para descobrir o total de linhas do arquivo
                sc.nextLine();
                totalLinesFile++;
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }

        int init = totalLinesFile / 2;              // variavel para armazenar qual linha começa a ter os dados dos nodos folhas;
        int tamVetor = init*2;   //setar o tamanho do vetor com base nas informações de linhas obtidas
        //System.out.println("Tamanho tamvetor" + tamVetor);  
            if ((totalLinesFile%2)==1) tamVetor=tamVetor+2;//Caso haja resto na divisao, é porque a um nodo pai com (presumesse) dois filhos
        int i = 0;                                  // contador para controle da releitura do arquivo
        int vectorValues[] = new int[tamVetor];     // vetor que contem os valores dos nodos com numeros(folhas)
        int vi = 0;                                 // variavel para controle de posicao na armazenagem do vetor
        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                i++;
                if (i > init) {                     //compara se a posicao de linha lida corresponde ao inicio dos valores
                  
                    String dados[] = linha.split(" ");
                    vectorValues[vi] = Integer.parseInt(dados[1]);//grava o segundo valor da linha no vetor
                    vi++;                                         //proxima posicao do vetor
                    vectorValues[vi] = Integer.parseInt(dados[2]);//grava o terceiro valor da linha no vetor
                    vi++;                                          //proxima posicao do vetor
                    
                }
            }            
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return vectorValues;*/

}
