import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class QuickSort {
    public void ordenarVetorDeInteiros(LinkedList<Compra> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private void quickSort(LinkedList<Compra> lista, int inicio, int fim) {
        if(fim > inicio) {

            int indexPivo = dividir(lista, inicio, fim);

            quickSort(lista, inicio, indexPivo - 1);

            quickSort(lista, indexPivo + 1, fim);
        }
    }

    private int dividir(LinkedList<Compra> lista, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = lista.get(inicio).getValorC();

        while(pontEsq <= pontDir) {
            while(pontEsq <= pontDir && lista.get(pontEsq).getValorC() <= pivo) {
                pontEsq++;
            }

            while(pontDir >= pontEsq && lista.get(pontDir).getValorC() > pivo) {
                pontDir--;
            }

            if(pontEsq < pontDir) {
                trocar(lista, pontDir, pontEsq);
                pontEsq++;
                pontDir--;
            }
        }

        trocar(lista, inicio, pontDir);
        return pontDir;
    }

    private void trocar(LinkedList<Compra> lista, int i, int j) {
        Compra temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}
