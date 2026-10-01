package jogovelha;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private boolean statusPartida;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = jogador1;
        this.statusPartida = true;
    }

    public void iniciarPartida() {
    }

    public boolean jogar(int linha, int coluna, Simbolo simbolo) {
        return tabuleiro.jogar(linha, coluna, simbolo);
    }

    public void alternarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    public boolean verificarEmpate() {
        if(tabuleiro.tabuleiroCheio()) {
            if(verificarVitoria()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void finalizarPartida() {
        statusPartida = false;
    }

    public boolean verificarVitoria() {
        for(int linha = 0; linha < 3; linha++) {
            Simbolo simbolo = tabuleiro.getSimbolo(linha, 0);
            if(simbolo != Simbolo.VAZIO) {
                if(simbolo == tabuleiro.getSimbolo(linha, 1)) {
                    if(simbolo == tabuleiro.getSimbolo(linha, 2)) {
                        return true;
                    }
                }
            }
        }

        for(int coluna = 0; coluna < 3; coluna++) {
            Simbolo simbolo = tabuleiro.getSimbolo(0, coluna);
            if(simbolo != Simbolo.VAZIO) {
                if(simbolo == tabuleiro.getSimbolo(1, coluna)) {
                    if(simbolo == tabuleiro.getSimbolo(2, coluna)) {
                        return true;
                    }
                }
            }
        }

        Simbolo simbolo = tabuleiro.getSimbolo(0, 0);
        if(simbolo != Simbolo.VAZIO) {
            if(simbolo == tabuleiro.getSimbolo(1, 1)) {
                if(simbolo == tabuleiro.getSimbolo(2, 2)) {
                    return true;
                }
            }
        }

        simbolo = tabuleiro.getSimbolo(0, 2);
        if(simbolo != Simbolo.VAZIO) {
            if(simbolo == tabuleiro.getSimbolo(1, 1)) {
                if(simbolo == tabuleiro.getSimbolo(2, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
