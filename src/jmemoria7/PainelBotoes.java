package jmemoria7;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//======================================

public final class PainelBotoes extends JPanel {

    private static final long serialVersionUID = -5277954808599926717L;
    Random RandomNumber = new Random();
    //------------
    public int pontos = 100;
    //------------
    private final Font Fonte = new Font("Lucida Console", Font.BOLD, 42);
    private final JLabel Pontuacao_do_Jogador = new JLabel("Pontos: " + pontos);

    private final JButton bt_Novo_Jogo = new JButton();
    private final JButton bt_Re_Iniciar_Jogo = new JButton();
    private final JButton bt_Estatisticas = new JButton();

    public int qtdeBotoes;

    public JButton botao[];
    public int Aleatorio[];
    public int Posicao_do_vetor_Aleatorio[];

    //======================================
    public PainelBotoes(JanelaPrincipal janelaPrincipal, int linhas, int colunas, int qdtBotoes) {
        setLayout(new GridLayout(linhas, colunas, 5, 5));
        this.qtdeBotoes = qdtBotoes;
        botao = new JButton[qtdeBotoes];
        Aleatorio = new int[qtdeBotoes];
        Posicao_do_vetor_Aleatorio = new int[qtdeBotoes];
        //int numero = (QtdeBotoes/2);
        for (int i = 0; i < qtdeBotoes; i++) {
            botao[i] = new JButton();
            botao[i].setFont(Fonte);
            botao[i].setVisible(true);
            add(botao[i]);
        }
        /*for (int lin = 0; lin < linhas; lin++) {
        for (int col = 0; col < colunas; col++) {
        //numero++;
        //final JButton botao = new JButton();    //String.valueOf(numero));
        botao[col] = new JButton();
        botao[col].setFont(Fonte);
        botao[col].setVisible(true);
        //botao[col].addActionListener(event -> clicouNoBotao(botao[col]));
        add(botao[col]);
        }
        }*/
        final int Aleatorio[] = new int[qtdeBotoes];
        final int Posicao_do_vetor_Aleatorio[] = new int[qtdeBotoes];
    }

    //====================================================
    private class Eventos_JogoDaMemoria implements ActionListener {

        int Cont_Acertos, Primeiro_Click, Segundo_Click;
        int Numero_Click, posi, cont, pontos_Anterior, Maior_Pontuacao_do_Jogador;
        int Partidas_jogadas = 0, Numero_de_Vitorias = 0;
        boolean Novo_Jogo = true;
        boolean Re_Iniciar = false;
        boolean Fim_de_Jogo = false;

        public void actionPerformed(ActionEvent event) {
            //if (event.getSource() == Sobre_JogoDaMemoria){
            //    new Sobre_Sobre_JogoDaMemoria(
            //            (int)getLocation().getX(),
            //            (int)getLocation().getY(),
            //JogoDaMemoria.this, true
            //).setVisible(true);
            //}

            if (event.getSource() == bt_Novo_Jogo) {
                Novo_Jogo = true;
                Re_Iniciar = false;
            }

            if (event.getSource() == bt_Re_Iniciar_Jogo) {
                Novo_Jogo = true;
                Re_Iniciar = true;
            }

            if (event.getSource() == bt_Estatisticas) {
                Fim_de_Jogo = true;
            }

            if (Novo_Jogo == true) {
                Cont_Acertos = 0;
                Partidas_jogadas++;
                pontos_Anterior = pontos;
                pontos = 100;
                Numero_Click = 0;
                posi = 0;
                cont = 16;
                Primeiro_Click = 0;
                Segundo_Click = 0;

                for (int i = 0; i < qtdeBotoes; ++i) {
                    botao[i].setText("");
                    botao[i].setEnabled(true);
                }

                if (Re_Iniciar == false) {
                    for (int i = 0; i < qtdeBotoes; ++i) {
                        Posicao_do_vetor_Aleatorio[i] = i;
                    }

                    for (int i = 0; i < (qtdeBotoes / 2); ++i) {
                        for (int j = 0; j < 2; ++j) {
                            posi = RandomNumber.nextInt(cont);
                            Aleatorio[Posicao_do_vetor_Aleatorio[posi]] = i;

                            if (posi < cont) {
                                for (int q = (posi + 1); q < (cont); ++q) {
                                    Posicao_do_vetor_Aleatorio[q - 1] = Posicao_do_vetor_Aleatorio[q];
                                }
                            }
                            cont--;
                        }
                    }
                }
                Novo_Jogo = false;
            }

            for (int i = 0; i < qtdeBotoes; ++i) {
                if (event.getSource() == botao[i]) {
                    botao[i].setText(String.valueOf(Aleatorio[i]));
                    botao[i].setEnabled(false);
                    botao[i].setVisible(true);
                    Numero_Click++;

                    if (Numero_Click == 1) {
                        Primeiro_Click = i;
                    }
                    if (Numero_Click == 2) {
                        Segundo_Click = i;
                        if (Aleatorio[Primeiro_Click] != Aleatorio[Segundo_Click]) {
                            pontos -= 2;
                            ///JOptionPane.showMessageDialog(jMemoria1.this, "Errado");
                            botao[Primeiro_Click].setText("");
                            botao[Segundo_Click].setText("");
                            botao[Primeiro_Click].setEnabled(true);
                            botao[Segundo_Click].setEnabled(true);

                        } else {
                            Cont_Acertos++;
                            pontos += 10;
                        }
                        Numero_Click = 0;
                    }
                }
            }

            if (Cont_Acertos == 8) {
                Numero_de_Vitorias++;
                Cont_Acertos = 0;

                if (pontos > pontos_Anterior) {
                    Maior_Pontuacao_do_Jogador = pontos;
                }
                Fim_de_Jogo = true;
            }

            if (pontos < 0) {
                pontos = 0;
            }
            Pontuacao_do_Jogador.setText("Pontos: " + pontos);

            if (Fim_de_Jogo == true) {
                Estatisticas_Jogo(Partidas_jogadas, Numero_de_Vitorias, Maior_Pontuacao_do_Jogador);
                Fim_de_Jogo = false;
            }
        }
    }

    //======================================
    void Estatisticas_Jogo(int Partidas_jogadas, int Numero_de_Vitorias, int Maior_Pontuacao_do_Jogador) {

        //    JOptionPane.showMessageDialog(JogoDaMemoria.this, "Partidas jogadas: " + Partidas_jogadas +
        //                    "\nVitórias: " + Numero_de_Vitorias +
        //                    "\nMaior Pontuação do Jogador: " + Maior_Pontuacao_do_Jogador);
    }

    //======================================
    private void clicouNoBotao(JButton botao) {
        // aqui tu implementa a lógica ao clicar num botão
        System.err.println(botao.getText());
    }
    //======================================

    public JButton[] getButtonsList() {
        return botao;
    }

}
