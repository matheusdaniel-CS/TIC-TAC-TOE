package jogovelha;

public class Tabuleiro {

    private Casa[][] casas;
    public Tabuleiro() {
        casas = new Casa[3][3];

        for(int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                casas[linha][coluna] = new Casa(linha, coluna);
            }
        }
    }

    public boolean jogar(int linha, int coluna, Simbolo simbolo) {
        if (posicaoValida(linha, coluna)) {
            casas[linha][coluna].setSimbolo(simbolo);
            return true;
        }
        return false;
    }

    private boolean posicaoValida(int linha, int coluna) {
        if (linha < 0) {
            return false;
        }

        if (linha >= 3) {
            return false;
        }

        if (coluna < 0) {
            return false;
        }

        if (coluna >= 3) {
            return false;
        }
        return true;
    }

    public boolean tabuleiroCheio() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if(casas[linha][coluna].statusCasa()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Simbolo getSimbolo(int linha, int coluna) {
        return casas[linha][coluna].getSimbolo();
    }

}
