package jogovelha;

public class Jogador {

    private String nome;
    private Simbolo simbolo;

    public Jogador(String nome, Simbolo simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
        //Aqui a gente pode futuramente fazer algo assim: Jogaor jogador1 = new Jogador("Izabele", Simbolo.X);
        //E depois jogador1.getNome();
    }

    public Simbolo getSimbolo() {
        return simbolo;
        //Mesma coisa, só que jogador1.getSimbolo(); :D
    }
}
