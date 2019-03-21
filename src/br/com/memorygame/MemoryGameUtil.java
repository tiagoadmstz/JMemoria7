/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.memorygame;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author tiago.teixeira
 */
public final class MemoryGameUtil {

    /**
     * Este método seleciona um número de imagens que é a metade do número de
     * botões informados no range e seta de aleatório um par de imagens dentro
     * dos botões informados dentro do array.
     *
     * @param buttons Array de botões que vão conter as imagens
     * @param path Nome da pasta onde estão as imagens
     * @param range Quantidade de botões que serão usados
     */
    public void embaralhar(JButton[] buttons, String path, int range) {
        //cria um random adapter para as imagens
        RandomAdapter rda_img = new RandomAdapter();
        //cria um random adapter para os botões
        RandomAdapter rda_bt = new RandomAdapter();
        //pega o caminho da pasta onde as imagens se encontram
        String path_img = System.getProperty("user.dir") + "\\Figuras\\" + path;
        //cria uma referência da pasta das imagens
        File file = new File(path_img);
        //recupera lista de imagens contidas na pasta
        String[] imgs = file.list();
        //faz um loop para escolher as imagens
        for (int a = 0; a < (range / 2); a++) {
            //pega uma imagem de forma aleatória
            String p = path_img + "\\" + imgs[rda_img.randomNoRepeat(range / 2)];
            //cria um icone com a imagem selecionada
            ImageIcon icon = new ImageIcon(p);
            //loop que seta a imagem seleciona em dois botões de forma aleatória
            for (int b = 0; b < 2; b++) {
                buttons[rda_bt.randomNoRepeat(range)].setIcon(icon);
            }
        }
    }

}
