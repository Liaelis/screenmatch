package ers.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ers.screenmatch.excecao.ErroDeConversaoDeAnoException;
import ers.screenmatch.modelo.Titulo;
import ers.screenmatch.modelo.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulosBusca = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("digite um filme para buscar");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {

                break;
            }
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=4d06331";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                titulosBusca.add(new Titulo(meuTituloOmdb)) ;
                System.out.println("Titulo já convertido");

                FileWriter escrita = new FileWriter("filme.txt", true);
                escrita.write(gson.toJson(titulosBusca));
                escrita.close();
                System.out.println(titulosBusca);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("O programa finalizou corretamente!");
    }
}
