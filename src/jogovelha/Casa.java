package jogovelha;

public class Casa {

    private int linha;
    private int coluna;
    private Simbolo simbolo;

    public Casa(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = Simbolo.VAZIO;
    }

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


