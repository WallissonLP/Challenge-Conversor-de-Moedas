package br.com.conversor;
public record DadosMoeda(String base_code,
                         String target_code,
                         double conversion_rate,
                         String conversion_rates,
                         double conversion_result) {
}
