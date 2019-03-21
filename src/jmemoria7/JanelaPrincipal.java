package jmemoria7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//======================================

public final class JanelaPrincipal extends JFrame {

    private static final long serialVersionUID = 3208861916546753489L;
    private static final String BOTOES_16 = "16";
    private static final String BOTOES_24 = "24";
    private static final String BOTOES_32 = "32";
    private int selectPanel = -1;

    private JPanel cardPanel;
    private CardLayout cardLayout;

    //======================================
    JanelaPrincipal() throws IOException {
        super("JOGO DA MEMÓRIA");
        Dimension size = new Dimension(680, 480);
        setSize(size);
        setMinimumSize(size);
        setLocationRelativeTo(null);

        JPanel container = new JPanel();
        container.setBackground(Color.BLUE);
        container.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        container.setLayout(new BorderLayout(5, 5));
        container.add(new PainelEsquerdo(this), BorderLayout.WEST);
        container.add(new PainelInferior(this), BorderLayout.SOUTH);
        container.add(criarCardlayout(), BorderLayout.CENTER);

        setContentPane(container);
    }

    //======================================
    public void mostraPainelBotoes16() {
        int QtdeBotoes = 16;
        JButton botao[] = new JButton[QtdeBotoes];
        int Aleatorio[] = new int[QtdeBotoes];
        int Posicao_do_vetor_Aleatorio[] = new int[QtdeBotoes];
        final JButton Escolha[] = new JButton[QtdeBotoes];
        cardLayout.show(cardPanel, BOTOES_16);
        selectPanel = 0;
    }

    //======================================
    public void mostraPainelBotoes24() {
        int QtdeBotoes = 24;
        JButton botao[] = new JButton[QtdeBotoes];
        int Aleatorio[] = new int[QtdeBotoes];
        int Posicao_do_vetor_Aleatorio[] = new int[QtdeBotoes];
        final JButton Escolha[] = new JButton[QtdeBotoes];
        cardLayout.show(cardPanel, BOTOES_24);
        selectPanel = 1;
    }

    //======================================
    public void mostraPainelBotoes32() {
        int QtdeBotoes = 32;
        JButton botao[] = new JButton[QtdeBotoes];
        int Aleatorio[] = new int[QtdeBotoes];
        int Posicao_do_vetor_Aleatorio[] = new int[QtdeBotoes];
        final JButton Escolha[] = new JButton[QtdeBotoes];
        cardLayout.show(cardPanel, BOTOES_32);
        selectPanel = 2;
    }

    //======================================
    private JPanel criarCardlayout() {
        cardLayout = new CardLayout(5, 5);
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(new PainelBotoes(this, 4, 4, 16), BOTOES_16);
        cardPanel.add(new PainelBotoes(this, 4, 6, 24), BOTOES_24);
        cardPanel.add(new PainelBotoes(this, 4, 8, 32), BOTOES_32);
        return cardPanel;
    }
    //======================================

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public int getSelectPanel() {
        return selectPanel;
    }

}
