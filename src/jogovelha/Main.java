package jogovelha;

public class Main {



    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Izabele", Simbolo.X);

        Jogador jogador2 = new Jogador("Matheus", Simbolo.O);
        
        Jogo jogo = new Jogo(jogador1, jogador2);

    }
}