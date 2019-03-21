/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.memorygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tiago.teixeira
 */
public final class RandomAdapter {

    private final List<Integer> valores;
    private final Random random;

    public RandomAdapter() {
        valores = new ArrayList();
        random = new Random();
    }

    /**
     * Este método faz escolha de número de forma aletória dentro de um range
     * sem repeti-los durante o uso da classe, sendo necessário zerados para
     * poder reutilizar a mesma instância da classe
     *
     * @param range Tamanho que o random irá obedecer
     * @return Um inteiro dentro do range sem repeti-los
     */
    public int randomNoRepeat(int range) {
        int v = 0;
        boolean exist = false;
        while (!exist) {
            v = random.nextInt(range);
            if (!valores.contains(v)) {
                valores.add(v);
                exist = true;
            }
        }
        return v;
    }

    /**
     * Limpa lista de valores usados no método randomNoRepeat
     */
    public void zerarRandomNoRepeat() {
        valores.clear();
    }

}
