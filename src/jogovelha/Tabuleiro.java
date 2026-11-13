package jogovelha;

//Classe responsável por representar todo o tabuleiro do jogo da velha
//Controla as casas, realiza e verifica as jogadas (dependendo das condições)
public class Tabuleiro {

    private Casa[][] casas;

    //Construtor que cria o tabuleiro 3x3 e inicia as 9 casas
    public Tabuleiro() {
        casas = new Casa[3][3];

        for(int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                casas[linha][coluna] = new Casa(linha, coluna);
            }
        }
    }

    //Ele verifica se a posição é válida e se a casa está vazia
    //Se as condições forem favoráveis, a jogada poderá ser realizada
    public boolean jogar(int linha, int coluna, Simbolo simbolo) {
        if (posicaoValida(linha, coluna)) {
            if (casas[linha][coluna].statusCasa()) {
                casas[linha][coluna].setSimbolo(simbolo);
                return true;
            }
        }
        return false;
    }

    //Aqui funciona a verificação da linha e coluna para respeitar o limite do tabuleiro
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
    //Verifica se todas as casas estão ocupadas
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
