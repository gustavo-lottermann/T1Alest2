import java.util.ArrayList;
import java.util.LinkedList;

public class QuickSort2 {
    public void ordenarVetorDeInteiros(LinkedList<Venda> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private void quickSort(LinkedList<Venda> lista, int inicio, int fim) {
        if(fim > inicio) {

            int indexPivo = dividir(lista, inicio, fim);

            quickSort(lista, inicio, indexPivo - 1);

            quickSort(lista, indexPivo + 1, fim);
        }
    }

    private int dividir(LinkedList<Venda> lista, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = lista.get(inicio).getValorV();

        while(pontEsq <= pontDir) {
            while(pontEsq <= pontDir && lista.get(pontEsq).getValorV() >= pivo) {
                pontEsq++;
            }

            while(pontDir >= pontEsq && lista.get(pontDir).getValorV() < pivo) {
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

    private void trocar(LinkedList<Venda> lista, int i, int j) {
        Venda temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}
