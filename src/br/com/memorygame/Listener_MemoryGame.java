/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.memorygame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author tiago.teixeira
 */
public class Listener_MemoryGame implements ActionListener {

    private final Form_Principal form;
    private MemoryGameUtil util;

    public Listener_MemoryGame(Form_Principal form) {
        this.form = form;
        initComponents();
    }

    private void initComponents() {
        util = new MemoryGameUtil();
        attachListener();
        carregaCategorias();
    }

    private void attachListener() {
        form.getButtonsList().forEach(bt -> bt.addActionListener(this));
        form.getColorButtonsList().forEach(bt -> {
            ((JButton) bt).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

            });
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "novoJogo":
                embaralhar();
                break;
            case "16":
                setButtonsPanel("card2");
                break;
            case "24":
                setButtonsPanel("card3");
                break;
            case "32":
                setButtonsPanel("card4");
                break;
        }
    }

    private void embaralhar() {
        int quant = Integer.parseInt(getSelectedRadioButton().getText());
        util.embaralhar(form.getButtonsList(getSelectedRadioButton().getText()).toArray(new JButton[quant]),
                form.getCbCategorias().getSelectedItem().toString(),
                quant);
    }

    private void setButtonsPanel(String name) {
        CardLayout layout = (CardLayout) form.getPainelButtons().getLayout();
        layout.show(form.getPainelButtons(), name);
    }

    private void carregaCategorias() {
        String path = System.getProperty("user.dir") + "\\Figuras";
        File dir = new File(path);
        for (String pasta : dir.list()) {
            form.getCbCategorias().addItem(pasta);
        }
    }

    private JRadioButton getSelectedRadioButton() {
        Enumeration<AbstractButton> rbs = form.getBgQtdImages().getElements();
        while (rbs.hasMoreElements()) {
            JRadioButton rb = (JRadioButton) rbs.nextElement();
            if (rb.isSelected()) {
                return rb;
            }
        }
        return null;
    }

}
