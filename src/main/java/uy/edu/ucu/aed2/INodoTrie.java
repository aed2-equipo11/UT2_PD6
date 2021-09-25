package uy.edu.ucu.aed2;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface INodoTrie {

    LinkedList<Integer> buscar(String patron); // devuelve la cantidad de comparaciones!

    void imprimir();

    void insertar(String unaPalabra, int pag);

}
