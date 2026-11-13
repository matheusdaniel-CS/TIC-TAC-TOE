package jogovelha;

//Classe responsável por representar o jogador no jogo da velha
//Armazena o nome e o símbolo que ele utiliza (Jogador X/Jogador O)
public class Jogador {

    private String nome;
    private Simbolo simbolo;

    //Construtor que cria um jogador com seu nome e símbolo
    public Jogador(String nome, Simbolo simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }
}
