package jogovelha;
import javax.swing.*;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.InputStream;

//Classe responsável pela interface do jogo da velha
//Exibe todo o tabuleiro, o placar, botões e interações dos jogadores
public class InterfaceJogo extends JFrame {

    private JPanel root;
    private JPanel tabuleiroPanel;
    private JButton[][] casasButton;
    private ImageIcon imagemX;
    private ImageIcon imagemO;
    private Jogo jogo;
    private JButton novaPartidaButton;
    private JButton sairButton;
    private int pontosX = 0;
    private int pontosO = 0;
    private int empates = 0;
    private JLabel statusLabel;
    private JLabel tituloLabel;
    private JPanel painelDireito;
    private JLabel tituloPlacarLabel;
    private JLabel textoEmpatesLabel;
    private JLabel empatesLabel;
    private JLabel pontosXLabel;
    private JLabel pontosOLabel;
    private JLabel nomeJogadorXLabel;
    private JLabel nomeJogadorOLabel;
    private Font fonte;
    private SonsJogo sons = new SonsJogo();

    //Construtor responsável por criar a interface e configurar toda a janela do jogo
    public InterfaceJogo(Jogo jogo) {

        //Carrega a fonte de texto utilizada nos textos dentro do jogo
        try (InputStream arq = getClass().getResourceAsStream("/fontes/Minecrafter.Reg.ttf")) {

            fonte = Font.createFont(Font.TRUETYPE_FONT, arq);

        } catch (Exception e) {

            fonte = new Font(Font.MONOSPACED, Font.BOLD, 20);
        }

        this.jogo = jogo;

        //Carrega e configura as imagens dos símbolos O e X
        ImageIcon simboloX = new ImageIcon(
                getClass().getResource("/imagens/simboloX.png")
        );

        ImageIcon simboloO = new ImageIcon(
                getClass().getResource("/imagens/simboloO.png")
        );

        Image imagemXRedimensionada = simboloX.getImage()
                .getScaledInstance(100, 100, Image.SCALE_REPLICATE);

        Image imagemORedimensionada = simboloO.getImage()
                .getScaledInstance(100, 100, Image.SCALE_REPLICATE);

        imagemX = new ImageIcon(imagemXRedimensionada);
        imagemO = new ImageIcon(imagemORedimensionada);

        //Cores utilizadas na interface
        //Como a cor de fundo (cinza), Cor dos jogadores (X e O)
        Color corFundo = new Color(0x131315);
        Color corX = new Color(57, 255, 69);
        Color corO = new Color(0, 229, 255);

        //Configura a imagem usada para o título do jogo
        tituloLabel = new JLabel();
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon imagemTitulo = new ImageIcon(
                getClass().getResource("/imagens/tituloJogo.png")
        );
        Image tituloAjustado = imagemTitulo.getImage()
                .getScaledInstance(600, 150, Image.SCALE_REPLICATE);
        tituloLabel.setIcon(new ImageIcon(tituloAjustado));

        //Imagem do placar que fica ao fundo das informações do jogo
        ImageIcon imagemTituloPlacar = new ImageIcon(
                getClass().getResource("/imagens/imagemPlacar.png")
        );
        Image imagemTituloRedimensionada = imagemTituloPlacar.getImage()
                        .getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        tituloPlacarLabel = new JLabel(new ImageIcon(imagemTituloRedimensionada));
        tituloPlacarLabel.setHorizontalAlignment(JLabel.CENTER);

        nomeJogadorXLabel = new JLabel("JOGADOR (X)");
        nomeJogadorXLabel.setHorizontalAlignment(JLabel.CENTER);
        nomeJogadorXLabel.setForeground(corX);
        nomeJogadorXLabel.setFont(fonte.deriveFont(16f));
        pontosXLabel = new JLabel("0");
        pontosXLabel.setFont(fonte.deriveFont(18f));
        pontosXLabel.setHorizontalAlignment((JLabel.CENTER));
        pontosXLabel.setForeground(corX);


        nomeJogadorOLabel = new JLabel("JOGADOR (O)");
        nomeJogadorOLabel.setHorizontalAlignment(JLabel.CENTER);
        nomeJogadorOLabel.setForeground(corO);
        nomeJogadorOLabel.setFont(fonte.deriveFont(16f));
        pontosOLabel = new JLabel("0");
        pontosOLabel.setFont(fonte.deriveFont(18f));
        pontosOLabel.setHorizontalAlignment((JLabel.CENTER));
        pontosOLabel.setForeground(corO);

        textoEmpatesLabel = new JLabel("EMPATES");
        textoEmpatesLabel.setHorizontalAlignment(JLabel.CENTER);
        textoEmpatesLabel.setFont(fonte.deriveFont(18f));
        textoEmpatesLabel.setForeground(Color.WHITE);

        empatesLabel = new JLabel("0");
        empatesLabel.setHorizontalAlignment(JLabel.CENTER);
        empatesLabel.setFont(fonte.deriveFont(20f));
        empatesLabel.setForeground(Color.WHITE);


        statusLabel = new JLabel("Vez de " + jogo.getJogadorAtual().getNome());
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(fonte.deriveFont(16f));
        statusLabel.setForeground(Color.WHITE);

        ImageIcon imagemStatus = new ImageIcon(
                getClass().getResource("/imagens/fundoStatus.png")
        );

        Image fundoStatusRedimensionado = imagemStatus.getImage()
                .getScaledInstance(220, 55, Image.SCALE_SMOOTH);


        statusLabel.setIcon(new ImageIcon(fundoStatusRedimensionado));


        statusLabel.setHorizontalTextPosition(JLabel.CENTER);
        statusLabel.setVerticalTextPosition(JLabel.CENTER);
        statusLabel.setPreferredSize(new Dimension(240, 65));


        //Cria o painel que fica na lateral
        root = new JPanel();
        root.setLayout(new BorderLayout());
        root.setBackground(corFundo);
        painelDireito = new JPanel();
        ImageIcon imagemOriginal = new ImageIcon(
                getClass().getResource("/imagens/fundoPlacar.png")
        );
        Image imagemRedimenisonada = imagemOriginal.getImage()
                .getScaledInstance(280, 380, Image.SCALE_SMOOTH);
        ImageIcon imagemPlacar = new ImageIcon(imagemRedimenisonada);
        JLabel fundoPlacar = new JLabel(imagemPlacar);
        fundoPlacar.setBackground(corFundo);
        fundoPlacar.setOpaque(true);
        fundoPlacar.setVerticalAlignment(JLabel.TOP);

        fundoPlacar.setLayout(new GridLayout(5,1));
        fundoPlacar.setBorder(
                BorderFactory.createEmptyBorder(0, 35, 0, 35)
        );

        //Organiza as informações exibidas dentro do placar
        //Nomes, pontuações, empates
        JPanel painelJogadorX = new JPanel();
        painelJogadorX.setLayout(new BorderLayout(10, 0));
        painelJogadorX.setOpaque(false);
        painelJogadorX.add(nomeJogadorXLabel, BorderLayout.WEST);
        painelJogadorX.add(pontosXLabel, BorderLayout.EAST);

        JPanel painelJogadorO = new JPanel();
        painelJogadorO.setLayout(new BorderLayout(10, 0));
        painelJogadorO.setOpaque(false);
        painelJogadorO.add(nomeJogadorOLabel, BorderLayout.WEST);
        painelJogadorO.add(pontosOLabel, BorderLayout.EAST);

        JPanel painelEmpates = new JPanel();
        painelEmpates.setLayout(new BorderLayout(10, 0));
        painelEmpates.setOpaque(false);
        painelEmpates.add(textoEmpatesLabel, BorderLayout.WEST);
        painelEmpates.add(empatesLabel, BorderLayout.EAST);

        painelDireito = new JPanel(new BorderLayout());
        painelDireito.setPreferredSize(new Dimension(280, 0));
        painelDireito.add(fundoPlacar, BorderLayout.CENTER);

        //Cria o tabuleiro visualmente com uma matriz para a criação dos 9 botões
        tabuleiroPanel = new JPanel();
        tabuleiroPanel.setLayout(new GridLayout(3, 3));
        tabuleiroPanel.setBackground(corFundo);
        casasButton = new JButton[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for(int coluna =0; coluna < 3; coluna++) {
                casasButton[linha][coluna] = new JButton();
                casasButton[linha][coluna].setContentAreaFilled(false);
                casasButton[linha][coluna].setBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 3)
                );
                casasButton[linha][coluna].setBorderPainted(true);
                casasButton[linha][coluna].setFocusPainted(false);
                tabuleiroPanel.add(casasButton[linha][coluna]);

                final int linhaAtual = linha;
                final int colunaAtual = coluna;

                //Um listiner para ao clicar em uma casa, realizar a jogada e atualizar a interface
                casasButton[linha][coluna].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Simbolo simbolo = jogo.getJogadorAtual().getSimbolo();
                        if (jogo.jogar(linhaAtual, colunaAtual, simbolo)) {
                            if (simbolo == Simbolo.X) {
                                casasButton[linhaAtual][colunaAtual].setIcon(imagemX);
                            } else if (simbolo == Simbolo.O) {
                                casasButton[linhaAtual][colunaAtual].setIcon(imagemO);
                            }
                            sons.tocarSom("/sons/somSimbolo.wav");

                            if (jogo.getStatusPartida() == true) {
                                statusLabel.setText("Vez de " + jogo.getJogadorAtual().getNome());
                            }
                            //Se a partida terminou, atualiza o vencedor ou o empate na parte do placar
                            if (jogo.getStatusPartida() == false) {
                                if(jogo.getVencedor() != null) {
                                    sons.tocarSom("/sons/somVitoria.wav");
                                    Simbolo simboloVencedor = jogo.getVencedor().getSimbolo();
                                    if (simboloVencedor == Simbolo.X) {
                                        pontosX++;
                                        pontosXLabel.setText(String.valueOf(pontosX));
                                    } else {
                                        pontosO++;
                                        pontosOLabel.setText(String.valueOf(pontosO));
                                    }

                                    statusLabel.setText(jogo.getVencedor().getNome() + " venceu!");
                                } else {
                                    sons.tocarSom("/sons/somEmpate.wav");
                                    empates++;
                                    empatesLabel.setText(String.valueOf(empates));
                                    statusLabel.setText("Empate!");
                                }
                            }

                        }
                    }
                });
            }
        }

        //Botão que inicia uma nova partida e limpa o tabuleiro
        novaPartidaButton = new JButton();

        ImageIcon imagemNovaPartida = new ImageIcon(
                getClass().getResource("/imagens/botaoNovaPartida.png")
        );

        Image imagemAjustada = imagemNovaPartida.getImage()
                        .getScaledInstance(190, 60, Image.SCALE_REPLICATE);

        novaPartidaButton.setIcon(new ImageIcon(imagemAjustada));
        novaPartidaButton.setPreferredSize(new Dimension(190, 60));
        novaPartidaButton.setContentAreaFilled(false);
        novaPartidaButton.setBorderPainted(false);
        novaPartidaButton.setFocusPainted(false);
        novaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sons.tocarSom("/sons/somClick.wav");
                jogo.iniciarPartida();
                for (int linha = 0; linha < 3; linha++) {
                    for(int coluna = 0; coluna < 3; coluna++) {
                        casasButton[linha][coluna].setIcon(null);
                    }
                }
            }
        });

        //Botão que ao ser clicado, encerra o jogo
        sairButton = new JButton();

        ImageIcon imagemSair = new ImageIcon(
                getClass().getResource("/imagens/botaoSair.png")
        );

        Image imagemSairAjustada = imagemSair.getImage()
                        .getScaledInstance(70, 60, Image.SCALE_REPLICATE);

        sairButton.setPreferredSize(new Dimension(70, 60));
        sairButton.setIcon(new ImageIcon(imagemSairAjustada));
        sairButton.setContentAreaFilled(false);
        sairButton.setBorderPainted(false);
        sairButton.setFocusPainted(false);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Organiza os 2 botões que fica abaixo do placar (Nova partida e Sair)
        JPanel painelBotoesInferior = new JPanel();
        painelBotoesInferior.setLayout(new BorderLayout());
        JPanel painelBotoes = new JPanel();
        painelBotoes.setPreferredSize(new Dimension(280, 70));
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        painelBotoesInferior.add(painelBotoes, BorderLayout.SOUTH);
        painelBotoesInferior.setBackground(corFundo);
        painelBotoes.add(novaPartidaButton);
        painelBotoes.add(sairButton);
        painelBotoes.setBackground(corFundo);

        //Imagem da moldura que fica abaixo do tabuleiro
        ImageIcon imagemMoldura = new ImageIcon(
                getClass().getResource("/imagens/bordaTabuleiro.png")
        );

        Image molduraRedimensionada = imagemMoldura.getImage()
                .getScaledInstance(480, 480, Image.SCALE_SMOOTH);

        JLabel molduraLabel = new JLabel(
                new ImageIcon(molduraRedimensionada)
        );

        JLayeredPane painelTabuleiroCentral = new JLayeredPane();

        painelTabuleiroCentral.setPreferredSize(new Dimension(480, 480));

        molduraLabel.setBounds(0, 0, 480, 480);

        tabuleiroPanel.setBounds(78, 82, 324, 324);

        painelTabuleiroCentral.add(
                molduraLabel, JLayeredPane.DEFAULT_LAYER
        );

        painelTabuleiroCentral.add(
                tabuleiroPanel, JLayeredPane.PALETTE_LAYER
        );

        //Adiciona todas as informações que aparecem no placar
        fundoPlacar.add(tituloPlacarLabel);
        fundoPlacar.add(painelJogadorX);
        fundoPlacar.add(painelEmpates);
        fundoPlacar.add(painelJogadorO);
        fundoPlacar.add(statusLabel);

        root.add(tituloLabel, BorderLayout.NORTH);
        JPanel painelJogo = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));

        painelJogo.setBackground(corFundo);
        tabuleiroPanel.setPreferredSize(new Dimension(450, 450));
        painelDireito.setPreferredSize(new Dimension(280, 450));
        painelJogo.add(painelTabuleiroCentral);
        painelDireito.add(painelBotoesInferior, BorderLayout.SOUTH);
        painelJogo.add(painelDireito);
        root.add(painelJogo, BorderLayout.CENTER);

        //Inicia a música que toca de fundo no jogo
        sons.tocarMusicaFundo();

        add(root);

        //Titulo do jogo (Que aparece na janela do jogo)
        //Também configura o tamanho da tela e força o jogador a não conseguir abri-la
        //Tela de 950x700
        setTitle("Jogo da Velha");

        ImageIcon iconeJogo = new ImageIcon(
                getClass().getResource("/imagens/iconeJogo.jpeg")
        );
        setIconImage(iconeJogo.getImage());


        setSize(950, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

