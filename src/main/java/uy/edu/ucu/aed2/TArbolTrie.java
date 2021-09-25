package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {
    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra, int pag) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(filtrarPalabra(palabra), pag);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public LinkedList<Integer> buscar(String palabra) {
        LinkedList<Integer> indices = new LinkedList<>();
        if (raiz != null) {
            indices = raiz.buscar(filtrarPalabra(palabra));
        }
        return indices;
    }

    public String filtrarPalabra(String palabra) {
        return palabra.toLowerCase().replaceAll("[^a-z]", "");
    }

    public void construirTrie(String secuencia) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.construirTrie(secuencia);
    }
}
