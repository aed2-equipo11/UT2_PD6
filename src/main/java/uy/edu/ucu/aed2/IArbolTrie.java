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
public interface IArbolTrie {

    void imprimir();

    LinkedList<Integer> buscar(String palabra);

    void insertar(String palabra, int pag);

}
