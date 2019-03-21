/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.memoria.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import br.com.memorygame.MemoryGameUtil;
import br.com.memorygame.RandomAdapter;
import org.junit.Test;

/**
 *
 * @author tiago.teixeira
 */
public class Testes {

    //@Test
    public void pathTest() {
        //"D:\\CURSOS E TREINAMENTOS\\JAVA\\PROJETOS JAVA\\Projetos JOGO DE MEMORIA\\JMemoria7\\JMemoria7\\Figuras"
        String path = System.getProperty("user.dir") + "\\Figuras";
        System.out.println(path);
    }

    //@Test
    public void randomNoReapetTest() {
        List<Integer> lista = new ArrayList();
        RandomAdapter util = new RandomAdapter();
        for (int i = 0; i < 32; i++) {
            lista.add(util.randomNoRepeat(32));
        }
        lista.stream().sorted().forEach(v -> System.out.println(v));
    }

    //@Test
    public void embaralharTest() {
        MemoryGameUtil mgu = new MemoryGameUtil();
        JButton[] bts = new JButton[16];
        for (int i = 0; i < 16; i++) {
            bts[i] = new JButton();
        }
        mgu.embaralhar(bts, "Bebidas", 16);
        Arrays.asList(bts).stream().map(bt -> bt.getIcon().toString()).sorted().forEach(icon -> System.out.println(icon));
    }

}
