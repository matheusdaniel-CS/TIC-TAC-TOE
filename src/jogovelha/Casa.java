package jogovelha;

//Classe responsável por representar uma casa do tabuleiro.
//Ela armazena a linha, a coluna e o símbolo dentro dela
public class Casa {

    private int linha;
    private int coluna;
    private Simbolo simbolo; // <-- atributos>

    //Construtor, responsável por criar uma casa em uma determinada posição do tabuleiro.
    //Inicialmente com o símbolo VAZIO
    public Casa(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = Simbolo.VAZIO;
    }

    //Ele verifica o statusCasa (se a casa está cheia ou vazia)
    //Ele retorna true se estiver vazio e false se estiver ocupado.
    public boolean statusCasa() {
        return simbolo == Simbolo.VAZIO;
    }


    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }
}


