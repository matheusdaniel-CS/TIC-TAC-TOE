package jogovelha;

public class Main {


       //IZA, isso aqui é somente para teste e testar se o jogo está funcionando, se as classes estão com a semantica e instanciadas certinho

        //Usamos o "Static" para não ter que criar um objeto com o Main!!
    public static void main(String[] args) {

        //Pra criar o primeiro Jogador (Estamos criando um objeto JOGADOR que recebe nome e simbolo)
        Jogador jogador1 = new Jogador("Izabele", Simbolo.X);

        //Para criar o segundo Jogador
        Jogador jogador2 = new Jogador("Matheus", Simbolo.O);

        //Para criar uma nova partida (Criamos o objeto JOGO, passando assim os dois jogadores para o construtor.
        Jogo jogo = new Jogo(jogador1, jogador2);

    }
}