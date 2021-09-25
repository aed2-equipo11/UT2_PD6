package uy.edu.ucu.aed2;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] sec = ManejadorArchivosGenerico.leerArchivo("./src/main/java/uy/edu/ucu/aed2/SECUENCIA.txt");
        String secLarga = sec[0];
        String patronBuscado = "ct";

        TArbolTrie trie = new TArbolTrie();

        trie.construirTrie(secLarga);

        LinkedList<Integer> indices = trie.buscar(patronBuscado);
        Iterator<Integer> itIndices = indices.iterator();
        int contador = 0;

        System.out.print(String.format("Indices de patrón %s: ", patronBuscado));
        while (itIndices.hasNext()) {
            contador++;
            Integer actual = itIndices.next();
            System.out.print(actual);
            if (itIndices.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println(String.format("Se encontraron %s ocurrencias", Integer.toString(contador)));
    }

    public static void buscarCT() {
        TArbolTrie trie = new TArbolTrie();

        trie.construirTrie("ccttgacttgc");

        LinkedList<Integer> indices = trie.buscar("ct");
        Iterator<Integer> itIndices = indices.iterator();

        System.out.print("Indices de patrón ct: ");
        while (itIndices.hasNext()) {
            Integer actual = itIndices.next();
            System.out.print(actual);
            if (itIndices.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}