package jogovelha;

//Classe responsável por iniciar o jogo
public class Main {

    //Criação dos jogadores, inicia o jogo e abre a interface gráfica
    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Jogador X", Simbolo.X);

        Jogador jogador2 = new Jogador("Jogador O", Simbolo.O);

        Jogo jogo = new Jogo(jogador1, jogador2);

        InterfaceJogo interfaceJogo = new InterfaceJogo(jogo);
    }
}