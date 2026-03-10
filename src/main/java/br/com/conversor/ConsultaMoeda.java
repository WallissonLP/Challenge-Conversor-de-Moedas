package br.com.conversor;

import com.google.gson.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    private static final Gson gson = new Gson();

    private final HttpClient client = HttpClient.newHttpClient();

    public DadosMoeda buscaCotacao(String moedaBase, String moedaAlvo, double valor) {
        String urlBase = ExchangeApiConfig.buildUrl(moedaBase, moedaAlvo);

        URI endereco = URI.create(urlBase + "/" + valor);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            
            HttpResponse<String> response = this.client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro na API: Status " + response.statusCode());
            }

            return gson.fromJson(response.body(), DadosMoeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a conversão: " + e.getMessage(), e);
        }
    }
}