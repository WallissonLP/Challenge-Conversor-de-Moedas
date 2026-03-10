package br.com.conversor;
public class ExchangeApiConfig {
    private static  final String ApiKey = System.getenv("MINHA_API_KEY");
    private static  final String urlBase = "https://v6.exchangerate-api.com/v6/"+ ApiKey +"/pair/";

    public static String buildUrl(String moedaBase, String moedaAlvo){
        return  urlBase + moedaBase + "/" + moedaAlvo;
    }
}
