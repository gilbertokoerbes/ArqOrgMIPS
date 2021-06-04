import javax.swing.JOptionPane;
//Desenvolvido por Arthur Gil e Gilberto Koerbes
public class App {
    public static void main(String[] args) {

            
        Arquivos arquivos = new Arquivos();

        arquivos.carregaCodificador();
        arquivos.salvaCode();

        JOptionPane.showMessageDialog(null, "CODIFICACAO EXECUTADA. Arquivo de saida criado. Clique OK para continuar a execucao", "InfoBox: " + "EXECUCAO", JOptionPane.INFORMATION_MESSAGE);

        arquivos.carregaDecodificador();
        arquivos.salvaDecoode();

        JOptionPane.showMessageDialog(null, "DE-CODIFICACAO EXECUTADA. Arquivo de saida criado. Clique OK para FINALIZAR", "InfoBox: " + "EXECUCAO", JOptionPane.INFORMATION_MESSAGE);

    }
}