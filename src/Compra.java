public class Compra implements Comparable<Compra>{
    private int quantidadeC;
    private int valorC;

    public Compra(int quantidadeC, int valorC) {
        this.quantidadeC = quantidadeC;
        this.valorC = valorC;
    }

    public int getQuantidadeC() {
        return quantidadeC;
    }

    public int getValorC() {
        return valorC;
    }

    public void setQuantidadeC(int quantidadeC1){
        quantidadeC = quantidadeC1;
    }


    public int compareTo(Compra outraCompra) {
        if(this.valorC > outraCompra.valorC){
            return 1;
        }
        else if(this.valorC < outraCompra.valorC){
            return -1;
        }
        return 0;
    }
}


