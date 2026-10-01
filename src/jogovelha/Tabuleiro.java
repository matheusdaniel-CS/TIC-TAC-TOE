package jogovelha;

public class Tabuleiro {

    private Casa[][] casas; //Usamos os dois colchetes: [][] para criar uma matriz 3x3

    public Tabuleiro() {
        casas = new Casa[3][3];

        for(int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                casas[linha][coluna] = new Casa(linha, coluna);
                //Ou seja, comece a Linha/Coluna em 0, e enquanto ela for menor que 3
                //ela aumenta/adiciona +1.
                //Então quando chegar 3 ela para. Formanod assim, o tabuleiro de 9 casas
                //Para o casas = new Casa, estamos pedindo para o java criar um novo objeto
                //que está 0 de linha e 0 coluna sendo vazio e o for vai passando em todos
                //criando uma casa vazia e guardano ela para usar depois!!
            }
        }
    }

    public boolean jogar(int linha, int coluna, Simbolo simbolo) {
        if (posicaoValida(linha, coluna)) {
            casas[linha][coluna].setSimbolo(simbolo);
            return true;
            //Aqui a gente ta pedinddo pro java encontrar a casa naquela posição
            //e setar o simbolo (chamando o método da classe CASA)
            //Quando formos jogar, será assim: tabuleiro.jogar(1, 2, Simbolo.O);
            //Então é como se fosse "Encontre a casa que ele quer e faça ela receber
            //aquele simbolo.
            //Então aquele exemplo ali que eu eu dei retornaria que a linha 1 coluna 2 passa a ter O!!
        }
        return false;
    }

    private boolean posicaoValida(int linha, int coluna) { //usamos private aqui porque somente o tabuleiro pode chamar posicaoValida();
        if (linha < 0) { //Se a linha for menor que 0, é invalida.
            return false;
        }

        if (linha >= 3) { //Se a linha for 3 ou maior, é invalida.
            return false;
        }

        if (coluna < 0) { //Mesma coisa
            return false;
        }

        if (coluna >= 3) { //Mesma coisa
            return false;
        }
        return true; //Se não encontrar nenhum problema, podemos dar como Posição Válida!!
    }

    public boolean tabuleiroCheio() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) { //Basicamente um for dentro do outro para percorrer toda linha e coluna
                if(casas[linha][coluna].statusCasa()) { //Ele verifica com o statusCasa se a Casa atual está vazia
                    return false; //Ou seja, se encontrar uma única casa vazia, o tabuleiro não vai estar cheio
                }
            }
        }
        return true; //E se nenhuma casa estiver vazia, o tabuleiro está cheio!!
        //Obs: apesar do nome do método, ele estará sempre procurando na verdade uma casa vazia.
    }

    public Simbolo getSimbolo(int linha, int coluna) {
        return casas[linha][coluna].getSimbolo(); //Como casas aqui no TABULEIRO é private,
        //o jogo não poderia fazer um tabuleiro.casas[0][0] por exemplo
        //Ou seja, ele não conseguiria consultar casas exatamente por ele ser private
        //Ele não deixará de ser private, mas abriremos tipo uma "porta" para que o jogo consiga
        //consulta-lo e pergunta-lo.
    }

}
