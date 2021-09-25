package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 4;
    private static final String CARACTERES = "acgt";
    private TNodoTrie[] hijos;
    //El atributo _comienzo_ indica el inicio del sufijo. Se comienza a indizar desde 1,
    //por lo que si comienzo == 0, el nodo no marca el final de una cadena
    private int comienzo;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
    }

    public void construirTrie(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            //Se pasa como parámetro i + 1 para ajustar el índice de comienzo del sufijo
            insertar(palabra.substring(i), i + 1);
        }
    }

    @Override
    public void insertar(String palabra, int pag) {
        TNodoTrie actual = this;
        for (int i = 0; i < palabra.length(); i++) {
            int indice = CARACTERES.indexOf(palabra.substring(i, i + 1));
            if (actual.hijos[indice] == null) {
                actual.hijos[indice] = new TNodoTrie();
            }
            actual = actual.hijos[indice];
        }
        actual.comienzo = pag;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.comienzo > 0) {
                StringBuilder salida = new StringBuilder();
                salida.append(s);
                salida.append(": ");
                salida.append(nodo.comienzo);
                System.out.println(salida.toString());
            }
            for (int i = 0; i < CANT_CHR_ABECEDARIO; i++) {
                if (nodo.hijos[i] != null) {
                    imprimir(s + CARACTERES.substring(i, i + 1), nodo.hijos[i]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie actual = this;
        for (int i = 0; i < s.length(); i++) {
            int indice = CARACTERES.indexOf(s.substring(i, i + 1));
            if (actual.hijos[indice] == null) {
                return null;
            }
            actual = actual.hijos[indice];
        }
        return actual;
    }

    private void buscar(LinkedList<Integer> indices) {
        if (comienzo > 0) {
            indices.add(comienzo);
        }
        for (int i = 0; i < hijos.length; i++) {
            if (hijos[i] != null) {
                hijos[i].buscar(indices);
            }
        }
    }

    @Override
    public LinkedList<Integer> buscar(String patron) {
        LinkedList<Integer> indices = new LinkedList<Integer>();
        TNodoTrie actual = buscarNodoTrie(patron);
        if (actual != null) {
            actual.buscar(indices);
        }
        return indices;
    }

    public int calcularComparaciones(String patron) {
        int comparaciones = 0;
        TNodoTrie actual = this;
        for (int i = 0; i < patron.length(); i++) {
            int indice = CARACTERES.indexOf(patron.substring(i, i + 1));
            comparaciones++;
            if (actual.hijos[indice] == null) {
                return 0;
            } else {
                actual = actual.hijos[indice];
            }
        }
        return comparaciones;
    }
}
