package jmemoria7;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
//======================================

public final class PainelInferior extends JPanel {

    private static final long serialVersionUID = -1201651846835565928L;
    private static final Font ARIAL_NARROW_BOLD_14 = new Font("Arial Narrow", Font.BOLD, 14);
    private static final Font ARIAL_NARROW_BOLD_18 = new Font("Arial Narrow", Font.BOLD, 18);
    private static final Font ARIAL_NARROW_BOLD_42 = new Font("Arial Narrow", Font.BOLD, 42);

    private int QtdeBotoes = 0;
    private static final int RADIO_16 = 16;
    private static final int RADIO_24 = 24;
    private static final int RADIO_32 = 32;
    //======================================
    private final JanelaPrincipal janelaPrincipal;
    private final JComboBox combo = new JComboBox();

    //======================================
    public PainelInferior(JanelaPrincipal janelaPrincipal) throws IOException {
        this.janelaPrincipal = janelaPrincipal;
        janelaPrincipal.setBackground(Color.cyan);
        this.setLayout(new GridLayout(1, 1));
        this.add(criarPainelCategoria());
        this.add(criarPainelPartidas());
        this.add(criarPainelSobeDesce());
    }

    //======================================
    public JPanel criarPainelCategoria() throws IOException {
        JLabel txtCategorias = new JLabel("Categorias: ");
        txtCategorias.setFont(ARIAL_NARROW_BOLD_14);
        txtCategorias.setPreferredSize(new Dimension(200, 20));

        combo.setPreferredSize(new Dimension(200, 20));
        CarregaCombo();

        JRadioButton rd1 = new JRadioButton("16 X", true);
        JRadioButton rd2 = new JRadioButton("24 X", false);
        JRadioButton rd3 = new JRadioButton("32 X", false);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rd1);
        grupo.add(rd2);
        grupo.add(rd3);

        Dimension radioSize = new Dimension(50, 20);
        rd1.setPreferredSize(radioSize);
        rd2.setPreferredSize(radioSize);
        rd3.setPreferredSize(radioSize);

        rd1.addItemListener(event -> selecionou(RADIO_16));
        rd2.addItemListener(event -> selecionou(RADIO_24));
        rd3.addItemListener(event -> selecionou(RADIO_32));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;    //na posição coluna 0
        c.gridy = 0;    //na posição linha 0
        c.gridwidth = 2;//aninha o objeto pelo tamanho de 2 celulas
        c.ipadx = 5;	//enchimento interno do componente - tamanho
        c.ipady = 5;	//enchimento interno do componente - largura
        //c.fill = GridBagConstraints.HORIZONTAL;//tamanho do componente em relação às celulas
        panel.add(txtCategorias, c);

        c = new GridBagConstraints();
        c.gridx = 2;	//na posição coluna 2
        c.gridy = 0;	//na posição linha 0
        c.gridwidth = 3;//aninha o objeto pelo tamanho de 2 celulas (largura)
        c.weighty = 1.0;
        c.ipadx = 5;	//enchimento interno do componente - tamanho
        c.ipady = 5;	//enchimento interno do componente - largura
        c.fill = GridBagConstraints.HORIZONTAL;//o componente ocupara toda a área horizontal
        panel.add(combo, c);

        c = new GridBagConstraints();
        c.gridx = 2;//na posição coluna 1
        c.gridy = 1;//na posição linha 1
        c.ipadx = 5;//enchimento interno do componente - tamanho
        c.ipady = 5;//enchimento interno do componente - largura
        panel.add(rd1, c);

        c = new GridBagConstraints();
        c.gridx = 3;//na posição coluna 2
        c.gridy = 1;//na posição linha 1
        c.ipadx = 5;//enchimento interno do componente - tamanho
        c.ipady = 5;//enchimento interno do componente - largura
        panel.add(rd2, c);

        c = new GridBagConstraints();
        c.gridx = 4;//na posição coluna 3
        c.gridy = 1;//na posição linha 1
        c.ipadx = 5;//enchimento interno do componente - tamanho
        c.ipady = 5;//enchimento interno do componente - largura
        panel.add(rd3, c);

        panel.setPreferredSize(new Dimension(200, 80));
        return panel;
    }

    //======================================
    public void CarregaCombo() {
        //isso está verdadeiramente HORRÍVEL. Preciso arrumar um modo de já iniciar no CAMINHO do jogo
        String path = System.getProperty("user.dir") + "\\Figuras";
        //File dir = new File("D:\\CURSOS E TREINAMENTOS\\JAVA\\PROJETOS JAVA\\Projetos JOGO DE MEMORIA\\JMemoria7\\JMemoria7\\Figuras");
        File dir = new File(path);
        //ArrayList<String> arquivos = new ArrayList<String>();
        String[] pastas = dir.list();
        for (String pasta : pastas) {
            combo.addItem(pasta);
        }
    }

    //======================================
    private JPanel criarPainelPartidas() {
        JLabel txtPartidas = new JLabel("Acertos:");
        JLabel txtQPartidas = new JLabel("0000");

        JLabel txtJogadas = new JLabel("Erros:");
        JLabel txtQJogadas = new JLabel("0000");

        Dimension txtSize = new Dimension(50, 20);
        txtPartidas.setPreferredSize(txtSize);
        txtJogadas.setPreferredSize(txtSize);

        Dimension txtqSize = new Dimension(50, 20);
        txtQPartidas.setPreferredSize(txtqSize);
        txtQJogadas.setPreferredSize(txtqSize);

        txtPartidas.setFont(ARIAL_NARROW_BOLD_14);
        txtJogadas.setFont(ARIAL_NARROW_BOLD_14);

        txtQPartidas.setFont(ARIAL_NARROW_BOLD_18);
        txtQJogadas.setFont(ARIAL_NARROW_BOLD_18);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(txtPartidas, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        panel.add(txtQPartidas, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        panel.add(txtJogadas, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        panel.add(txtQJogadas, c);
        panel.setPreferredSize(new Dimension(50, 80));
        return panel;
    }

    //======================================
    private JPanel criarPainelSobeDesce() {
        JButton btnStart = new JButton("");
        JButton btnPausa = new JButton("");
        JButton btnReset = new JButton("");

        JLabel lblCronos = new JLabel();
        lblCronos.setSize(150, 30);
        lblCronos.setForeground(Color.white);
        lblCronos.setHorizontalAlignment(JLabel.CENTER);
        lblCronos.setText("00:00:00");
        lblCronos.setFont(ARIAL_NARROW_BOLD_42);

        JPanel jpCronos = new JPanel();
        jpCronos.setLayout(new GridLayout(2, 1));
        jpCronos.setSize(200, 50);
        jpCronos.setBackground(Color.BLUE);

        jpCronos.add(lblCronos);

        btnStart.setBackground(Color.GREEN);
        btnStart.setToolTipText("BtnStart");
        btnPausa.setBackground(Color.YELLOW);
        btnReset.setBackground(Color.RED);

        btnStart.setFont(ARIAL_NARROW_BOLD_14);
        btnPausa.setFont(ARIAL_NARROW_BOLD_14);
        btnReset.setFont(ARIAL_NARROW_BOLD_14);

        Dimension size = new Dimension(50, 10);
        btnStart.setPreferredSize(size);
        btnPausa.setPreferredSize(size);
        btnReset.setPreferredSize(size);

        btnStart.addActionListener(event -> Start());
        btnPausa.addActionListener(event -> Pausa());
        btnReset.addActionListener(event -> Reset());

        JPanel ControlCronos = new JPanel();
        ControlCronos.setForeground(Color.cyan);
        jpCronos.setSize(150, 10);

        ControlCronos.add(btnStart);
        ControlCronos.add(btnPausa);
        ControlCronos.add(btnReset);

        jpCronos.add(ControlCronos);

        JPanel panel = new JPanel();    //(new FlowLayout(FlowLayout.CENTER, 5, 5));

        panel.add(jpCronos);

        //panel.add(btnStart);
        //panel.add(btnPausa);
        //panel.add(btnReset);
        return panel;
    }

    //======================================
    private void Start() {
        // Aqui vai a lógica do botão Desce
    }

    //======================================
    private void Pausa() {
        // Aqui vai a lógica do botão Sobe
    }

    //======================================
    private void Reset() {
        // Aqui vai a lógica do botão Sobe
    }

    //======================================
    private void selecionou(int radio) {
        switch (radio) {
            case RADIO_16:
                QtdeBotoes = 16;
                janelaPrincipal.mostraPainelBotoes16();
                return;
            case RADIO_24:
                QtdeBotoes = 24;
                janelaPrincipal.mostraPainelBotoes24();
                return;
            case RADIO_32:
                QtdeBotoes = 32;
                janelaPrincipal.mostraPainelBotoes32();
        }
    }
    //======================================

    public JComboBox getComboImages() {
        return combo;
    }

    public int getQtdeBotoes() {
        return QtdeBotoes;
    }

}
