package ers.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ers.screenmatch.modelo.Titulo;
import ers.screenmatch.modelo.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura  = new Scanner(System.in);
        System.out.println("digite um filme para buscar");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=4d06331";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String json = response.body();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOmdb meuTitulo = gson.fromJson(json, TituloOmdb.class);
        System.out.println("Titulo: "+ meuTitulo);

    }
}
