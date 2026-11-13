package jogovelha;

//Classe responsável pelo controle das regras e todo o andamento do jogo
//Ele gerencia os jogadores, as jogadas e as condições de vitória e empate
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private boolean statusPartida;

    //Construtor responsável por criar o jogo com dois jogadores e iniciar a partida
    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = jogador1;
        this.statusPartida = true;
    }

    //Reicinia a partida, criando um novo tabuleiro e definindo o primeiro jogador (jogador 1)
    public void iniciarPartida() {
        tabuleiro = new Tabuleiro();
        jogadorAtual = jogador1;
        statusPartida = true;
    }

    //Realiza a jogada e verifica uma possível vitória ou empate
    //Se a partida continuar, ele alterna para o próximo jogador
    public boolean jogar(int linha, int coluna, Simbolo simbolo) {
        if (statusPartida == false) {
            return false;
        }
        if (simbolo != jogadorAtual.getSimbolo()) {
            return false;
        }

        if (tabuleiro.jogar(linha, coluna, simbolo)) {
            if (verificarVitoria()) {
                finalizarPartida();
                return true;
            }

            if (verificarEmpate()) {
                finalizarPartida();
                return true;
            }

            alternarJogador();
            return true;
        }

        return false;
    }

    //Alterna a vez entre os dois jogadores
    public void alternarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public Simbolo getSimbolo(int linha, int coluna) {
        return tabuleiro.getSimbolo(linha, coluna);
    }

    public boolean getStatusPartida() {
        return statusPartida;
    }

    //Ele verifica QUAL jogador venceu ou retorna null se não existir um
    public Jogador getVencedor() {
        if (verificarVitoria()) {
            return jogadorAtual;
        }
        return null;
    }

    //Ele verifica se o tabuleiro está cheio e se não aconteceu uma vitória, resultando em um empate
    public boolean verificarEmpate() {
        if(tabuleiro.tabuleiroCheio()) {
            if(verificarVitoria()) {
                return false;
            }
            return true;
        }
        return false;
    }

    //Finaliza a partida e impede dos jogadores realizarem jogadas
    public void finalizarPartida() {
        statusPartida = false;
    }

    //Percorre e verifica se existem três símbolos iguais em alguma linha, coluna ou diagonal
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
