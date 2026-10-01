package jogovelha;

public class Casa {

 //<Tudo para indicar qual linha, coluna e qual simbolo>
    //<está a casa>
    private int linha;
    private int coluna;
    private Simbolo simbolo; // <-- atributos>

    //<Construtor da classe Casa>
    public Casa(int linha, int coluna) { //<-- Valor que vai receber em int
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = Simbolo.VAZIO;
        //Usamos o this para indicar que vamos pegar o valor que recebemos
        //no public Casa() e colocamos o valor no atributo da linha lá em cima!!
        //por exemplo no main: Casa casa = new Casa(1, 2); (linha = 1, coluna = 2, simbolo = vazio)
    }

    public boolean statusCasa() {
        return simbolo == Simbolo.VAZIO;
        //Se o simbolo for igual ao Simbolo.VAZIO (estiver vazio), ele retornará como true
        //Se a casa estiver com "X" ou "O", retornará false
    }


    public int getLinha() {
        return linha;
        //Para consultar a linha da casa e retornar o valor que está atribuido nela
        //exemplo Casa casa = new Casa(1, 2); <-- ele retornará 1!!
    }

    public int getColuna() {
        return coluna;
    }

    public Simbolo getSimbolo() {
        return simbolo;
        //Ele vai retornar o simbolo que está na casa
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
        //Ele vai alterar o simbolo que está na Casa!!
    }
}


