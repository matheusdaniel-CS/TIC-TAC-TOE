package jogovelha;

public class Jogo {
    private Tabuleiro tabuleiro; //Guara o tabuleiro a partida (Ele precisa ter acesso ao tabuleiro dãhhh, OI IZA)
    private Jogador jogador1; //Salva o primeiro jogador
    private Jogador jogador2; //Salva o seguno jogador
    private Jogador jogadorAtual; //Guarda na memória o jogador que está jogando
    private boolean statusPartida; //Indica se a partida está acontecendo (Ou seja, se true, ela está acontecendo, se false, ela foi encerrada)

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1; //Está guardando o primeiro jogador da partida
        this.jogador2 = jogador2; //Mesma coisa
        this.tabuleiro = new Tabuleiro(); //Ele criará um novo tabuleiro para a partida
        this.jogadorAtual = jogador1; //Ou seja, a gente definiu que o jogador 1 será o primeiro a jogar
        this.statusPartida = true;
    }

    public void iniciarPartida() {
        //Isso aqui servirá quanto começarmos a parte 2 (implementar a GUI do projeto)
        //Será um botão..!!
    }

    public boolean jogar(int linha, int coluna, Simbolo simbolo) { //A ideia aqui é ele receber a jogada e mandar a classe TABULEIRO tentar fazer acontecer.
        return tabuleiro.jogar(linha, coluna, simbolo);
        //Ou seja, um exemplo, se alguém chamar:
        //jogo.jogar(1, 2, Simbolo.X);
        //O jogo vai estar recebendo, linha 1, coluna 2, e Simbolo.X que é o simbolo que será colocado lá.
        //E então ele vai repassar essas informações para o tabuleiro.jogar(linha, coluna, simbolo); :D
        //Ou seja, vai do JOGO --> TABULEIRO --> CASA!!
        //O return serve para devolver o resultado que o TABULEIRO recebeu, ou seja, true ou false (jogada feita ou posição inválida)
        //Obs... O jogo nem sabe como a casa é alterada, quem está fazendo isso é o tabuleiro (figurinha de joinha)
    }

    public void alternarJogador() {
        if (jogadorAtual == jogador1) { //Ele verifica se o jogador atual é o jogador 1
            jogadorAtual = jogador2; //Se for, ele vai passar a vez para o jogador 2
        } else {
            jogadorAtual = jogador1; //Se não, ele passa a vez para o jogador 1
        }
    }

    public boolean verificarEmpate() {
        if(tabuleiro.tabuleiroCheio()) { //Ele verifica se o tabuleiro está cheio
            if(verificarVitoria()) { //Verifica se alguém venceu
                return false; //Se alguém venceu, não houve nenhum empate!!
            }
            return true; //Se o tabuleiro está cheio e ninguém venceu, houve empate
        }
        return false;
        //RESUMAO: Tabuleiro cheio?
        //SIM
        //Alguém venceu?
        //SIM -> false
        //NÃO -> true (empate)
    }

    public void finalizarPartida() {
        statusPartida = false; //Indicando que a partida terminou.
    }

    public boolean verificarVitoria() {
        for(int linha = 0; linha < 3; linha++) { //Percorre todas as 3 linhas do tabuleiro (aqui é tudo sobre linha)
            Simbolo simbolo = tabuleiro.getSimbolo(linha, 0); //Aqui ele está pegando o simbolo da primeira casa da linha
            if(simbolo != Simbolo.VAZIO) { //Verifica se a casa não está vazia
                if(simbolo == tabuleiro.getSimbolo(linha, 1)) { //Compara com a segunda casa da linha
                    if(simbolo == tabuleiro.getSimbolo(linha, 2)) { //E por fim compara com a terceira casa da linha
                        return true;
                    }
                }
            }
        }
        //Mesma coisa só que pra coluna!!
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
        //As diagonais principais
        Simbolo simbolo = tabuleiro.getSimbolo(0, 0);
        if(simbolo != Simbolo.VAZIO) {
            if(simbolo == tabuleiro.getSimbolo(1, 1)) {
                if(simbolo == tabuleiro.getSimbolo(2, 2)) {
                    return true;
                }
            }
        }
        //Segunda diagonal
        simbolo = tabuleiro.getSimbolo(0, 2);
        if(simbolo != Simbolo.VAZIO) {
            if(simbolo == tabuleiro.getSimbolo(1, 1)) {
                if(simbolo == tabuleiro.getSimbolo(2, 0)) {
                    return true;
                }
            }
        }
        return false; //<-- Retorna false se nenhuma vitória foi encontrada.
        //obs... (IZA, PAY ATTENTION HERE, PLS) Estamos usando bastante tabuleiro.getSimbolo() ao invés de tabuleiro.casas[]
        //Isso acontece por causa do encapsulamento, pois "casas" é private, ou seja,
        //A classe Jogo não pode mexer diretamente nela, muito menos CONSULTA-LA, então criando aquele método público que criamos
        //fez com que ele conseguisse consultar todas as casas no for e então ver qual simbolo continha nelas e dar o veredito!!
        //Então seria assim:
        //Jogo -> "Tabuleiro, me diga o simbolo de tal casa"
        //Tabuleiro -> "Casa, qual é o seu simbolo?"
        //Casa -> "X, meu amigão do Ford Ka"
        //Taubleiro -> "Jogo, é o X!!"
        //E o jogo faz isso todo o For para comparar todas as casas e verificar se houve a vitória
    }
}
