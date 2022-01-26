import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Executa {

    public static Scanner teclado = new Scanner(System.in);

    public void executa(){

        long startTime2 = System.nanoTime();

        ArrayList<Compra> listaCompra = new ArrayList<>();
        ArrayList<Venda> listaVenda = new ArrayList<>();

        QuickSort quick = new QuickSort();
        QuickSort2 quick2 = new QuickSort2();

        long lucro = 0;
        int qtd = 0;


        System.out.println("Digite o arquivo .txt que deseja fazer a leitura: ");
        String arquivo = teclado.nextLine();

        Path filePath = Paths.get(arquivo);


        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                try{
                    ArrayList<String> info = new ArrayList<>(Arrays.asList(line.split(" ")));
                    if(info.get(0).contains("V")){
                        Venda venda = new Venda(Integer.parseInt(info.get(1)), Integer.parseInt(info.get(2)));
                        listaVenda.add(venda);
                        Collections.sort(listaVenda);
                        //quick2.ordenarVetorDeInteiros(listaVenda);

                    } else if(info.get(0).contains("C")){
                        Compra compra = new Compra(Integer.parseInt(info.get(1)), Integer.parseInt(info.get(2)));
                        listaCompra.add(compra);
                        Collections.sort(listaCompra);
                        //quick.ordenarVetorDeInteiros(listaCompra);

                    }


                    int indiceC = listaCompra.size() - 1;
                    int indiceV = listaVenda.size() - 1;
                    if (indiceC >= 0 && indiceV >= 0) {
                        while(listaCompra.get(indiceC).getValorC() >= listaVenda.get(indiceV).getValorV()) {

                            if (listaCompra.get(indiceC).getQuantidadeC() - listaVenda.get(indiceV).getQuantidadeV() > 0) {
                                int precoC = listaVenda.get(indiceV).getQuantidadeV() * listaCompra.get(indiceC).getValorC();
                                int precoV = listaVenda.get(indiceV).getQuantidadeV() * listaVenda.get(indiceV).getValorV();
                                lucro = lucro + (precoC - precoV);
                                qtd = qtd + listaVenda.get(indiceV).getQuantidadeV();
                                int novaQnt = listaCompra.get(indiceC).getQuantidadeC() - listaVenda.get(indiceV).getQuantidadeV();
                                listaVenda.remove(indiceV);
                                listaCompra.get(indiceC).setQuantidadeC(novaQnt);
                                indiceV--;

                            } else if (listaCompra.get(indiceC).getQuantidadeC() - listaVenda.get(indiceV).getQuantidadeV() < 0) {
                                int precoC = listaCompra.get(indiceC).getQuantidadeC() * listaCompra.get(indiceC).getValorC();
                                int precoV = listaCompra.get(indiceC).getQuantidadeC() * listaVenda.get(indiceV).getValorV();
                                lucro = lucro + (precoC - precoV);
                                qtd = qtd +listaCompra.get(indiceC).getQuantidadeC();
                                int novaQnt = listaVenda.get(indiceV).getQuantidadeV() - listaCompra.get(indiceC).getQuantidadeC();
                                listaCompra.remove(indiceC);
                                listaVenda.get(indiceV).setQuantidadeV(novaQnt);
                                indiceC--;

                            } else {
                                int precoC = listaCompra.get(indiceC).getQuantidadeC() * listaCompra.get(indiceC).getValorC();
                                int precoV = listaCompra.get(indiceC).getQuantidadeC() * listaVenda.get(indiceV).getValorV();
                                lucro = lucro + (precoC - precoV);
                                qtd = qtd + listaCompra.get(indiceC).getQuantidadeC();
                                listaVenda.remove(indiceV);
                                listaCompra.remove(indiceC);
                                indiceC--;
                                indiceV--;

                            }
                        }
                    }


                } catch(NumberFormatException e){
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Houve algum erro na leitura do arquivo!");
        }

        long totalTime2 = System.nanoTime() - startTime2;

        double time=totalTime2/1000000000d;

        System.out.println("O método foi executado em " + time + " milissegundos");


        System.out.println("Lucro: " + lucro + "\nAções negociadas: " + qtd + "\nCompras ainda pendentes: " + listaCompra.size() + "\nVendas ainda pendentes: " + listaVenda.size());


    }
}