package jmemoria7;

import br.com.memorygame.MemoryGameUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//======================================

public final class PainelEsquerdo extends JPanel {

    private static final long serialVersionUID = 4473385492286142401L;
    private static final Font ARIAL_NARROW_BOLD_14 = new Font("Arial Narrow", Font.BOLD, 14);
    private static final Font ARIAL_NARROW_BOLD_18 = new Font("Arial Narrow", Font.BOLD, 18);
    private final MemoryGameUtil mgu = new MemoryGameUtil();

    private final JButton botaoNovo;
    private final JButton botaoPausar;
    private final JButton botaoSobre;
    private final JButton botaoSair;

    private final JLabel txtTempo;
    private final JLabel txtClicks;
    private final JLabel txtDireto;
    private final JLabel lblTempo;
    private final JLabel lblClicks;
    private final JLabel lblDireto;
    private final JanelaPrincipal janelaPrincipal;

    //======================================
    public PainelEsquerdo(JanelaPrincipal janelaPrincipal) {
        /*
        Dimension tamanhoPainel = new Dimension(150, 300);
        setPreferredSize(tamanhoPainel);
        setBackground(Color.YELLOW);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         */
        this.janelaPrincipal = janelaPrincipal;
        Dimension tamanhoPainel = new Dimension(150, 300);
        setPreferredSize(tamanhoPainel);
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel(new GridLayout(4, 1));
        setBackground(Color.green);
        botaoNovo = new JButton("Novo Jogo");
        botaoPausar = new JButton("Pausar");
        botaoSobre = new JButton("Sobre");
        botaoSair = new JButton("Sair");

        botaoNovo.setFont(ARIAL_NARROW_BOLD_18);
        botaoPausar.setFont(ARIAL_NARROW_BOLD_18);
        botaoSobre.setFont(ARIAL_NARROW_BOLD_18);
        botaoSair.setFont(ARIAL_NARROW_BOLD_18);

        panel1.add(botaoNovo);
        panel1.add(botaoNovo);
        panel1.add(botaoPausar);
        panel1.add(botaoSobre);
        panel1.add(botaoSair);

        JPanel panel2 = new JPanel(new GridLayout(3, 2));
        setBackground(Color.cyan);

        txtTempo = new JLabel("Tempo");
        lblTempo = new JLabel("0000");
        txtClicks = new JLabel("Clicks");
        lblClicks = new JLabel("0000");
        txtDireto = new JLabel("Direto");
        lblDireto = new JLabel("0000");

        txtTempo.setFont(ARIAL_NARROW_BOLD_14);
        txtClicks.setFont(ARIAL_NARROW_BOLD_14);
        txtDireto.setFont(ARIAL_NARROW_BOLD_14);

        txtTempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClicks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblTempo.setFont(ARIAL_NARROW_BOLD_18);
        lblClicks.setFont(ARIAL_NARROW_BOLD_18);
        lblDireto.setFont(ARIAL_NARROW_BOLD_18);

        panel2.add(txtTempo);
        panel2.add(lblTempo);
        panel2.add(txtClicks);
        panel2.add(lblClicks);
        panel2.add(txtDireto);
        panel2.add(lblDireto);

        this.add(panel1);
        this.add(panel2);

        botaoNovo.addActionListener(event -> NovoJogo());
        botaoPausar.addActionListener(event -> Pausar());
        botaoSobre.addActionListener(event -> Sobre());
        botaoSair.addActionListener(event -> sair());
    }//======================================

    private void Sobre() {
        // aqui tu implementa a lógica do Continuar
    }//======================================

    private void NovoJogo() {
        // aqui tu implementa a lógica do Iniciar
        //botaoIniciar.setEnabled(false);
        PainelBotoes pb = null;
        PainelInferior pi = null;
        for (Component comp : janelaPrincipal.getContentPane().getComponents()) {
            if (comp instanceof PainelInferior) {
                pi = (PainelInferior) comp;
            }
        }
        for (Component comp : janelaPrincipal.getCardPanel().getComponents()) {
            pb = (PainelBotoes) comp;
            if (comp instanceof PainelBotoes) {
                switch (janelaPrincipal.getSelectPanel()) {
                    case 0:
                        if (pb.isVisible()) {
                            mgu.embaralhar(pb.getButtonsList(), pi.getComboImages().getSelectedItem().toString(), 16);
                            break;
                        }
                    case 1:
                        if (pb.isVisible()) {
                            mgu.embaralhar(pb.getButtonsList(), pi.getComboImages().getSelectedItem().toString(), 24);
                            break;
                        }
                    case 2:
                        if (pb.isVisible()) {
                            mgu.embaralhar(pb.getButtonsList(), pi.getComboImages().getSelectedItem().toString(), 32);
                            break;
                        }
                }
                pb.repaint();
            }
        }
    }//======================================

    private void Pausar() {
        // aqui tu implementa a lógica do Pausar
    }//======================================

    private void sair() {
        // aqui tu implementa a lógica do Sair
        System.exit(0);
    }
//======================================
}
