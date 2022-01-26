public class Venda implements Comparable<Venda> {
    private int quantidadeV;
    private int valorV;

    public Venda(int quantidadeV, int valorV) {
        this.quantidadeV = quantidadeV;
        this.valorV = valorV;
    }

    public int getQuantidadeV() {
        return quantidadeV;
    }

    public int getValorV() {
        return valorV;
    }

    public void setQuantidadeV(int quantidadeV1) {
        quantidadeV = quantidadeV1;
    }

    public int compareTo(Venda outraVenda) {
        if(this.valorV < outraVenda.valorV){
            return 1;
        }
        else if(this.valorV > outraVenda.valorV){
            return -1;
        }
        return 0;
    }
}
