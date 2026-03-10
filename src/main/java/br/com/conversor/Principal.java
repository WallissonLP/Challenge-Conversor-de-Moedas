package br.com.conversor;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)
            throws IOException, InterruptedException {

        ConsultaMoeda consulta = new ConsultaMoeda();
        
        try (Scanner leitura = new Scanner(System.in)) {
            int opcao = 0;

            String menu = """
                    \n******************************************
                    SEJA BEM-VINDO AO CONVERSOR DE MOEDAS!
                    
                    1) Dólar [USD] =>> Real [BRL]
                    2) Real [BRL] =>> Dólar [USD]
                    3) Euro [EUR] =>> Real [BRL]
                    4) Real [BRL] =>> Euro [EUR]
                    5) Outras moedas (digite os códigos)
                    6) Sair
                    ******************************************
                    """;

            while (opcao != 6) {
                System.out.println(menu);
                System.out.print("Escolha uma opção válida: ");
                
                if (!leitura.hasNextInt()) {
                    System.out.println("Erro: Por favor, digite apenas o número da opção.");
                    leitura.next(); 
                    continue;
                }

                opcao = leitura.nextInt();
                leitura.nextLine(); 

                if (opcao == 6) break;

                String[] moedas = switch (opcao) {
                    case 1 -> new String[]{"USD", "BRL"};
                    case 2 -> new String[]{"BRL", "USD"};
                    case 3 -> new String[]{"EUR", "BRL"};
                    case 4 -> new String[]{"BRL", "EUR"};
                    case 5 -> {
                        System.out.print("Digite o código da moeda de origem (ex: GBP): ");
                        String base = leitura.nextLine().toUpperCase();
                        System.out.print("Digite o código da moeda de destino (ex: BRL): ");
                        String alvo = leitura.nextLine().toUpperCase();
                        yield new String[]{base, alvo};
                    }
                    default -> null;
                };

                if (moedas == null) {
                    System.out.println("Opção inválida! Escolha um número de 1 a 6.");
                    continue;
                }

                String moedaBase = moedas[0];
                String moedaAlvo = moedas[1];

                System.out.print("Digite o valor que deseja converter: ");
                
                if (!leitura.hasNextDouble()) {
                    System.out.println("Valor inválido! Use números (ex: 10,50 ou 100).");
                    leitura.next(); 
                    continue;
                }
                
                double valor = leitura.nextDouble();

                try {
                    DadosMoeda resultado = consulta.buscaCotacao(moedaBase, moedaAlvo, valor);

                    String simboloBase = getSimbolo(resultado.base_code());
                    String simboloAlvo = getSimbolo(resultado.target_code());

                    System.out.println("\n------------------------------------------");
                    System.out.println("        RESULTADO DA CONVERSÃO            ");
                    System.out.println("------------------------------------------");
                    System.out.printf("Valor original:   %s %.2f [%s]\n", simboloBase, valor, resultado.base_code());
                    System.out.printf("Taxa de câmbio:  %.4f\n", resultado.conversion_rate());
                    System.out.printf("Valor convertido: %s %.2f [%s]\n", simboloAlvo, resultado.conversion_result(), resultado.target_code());
                    System.out.println("------------------------------------------");

                    System.out.println("\nA retornar ao menu principal...");
                    Thread.sleep(2500); 

                } catch (Exception e) {
                    System.out.println("Erro ao processar conversão: " + e.getMessage());
                    Thread.sleep(1500);
                }
            }
        } 
        
        System.out.println("\nObrigado por usar o conversor! Até logo.");
    }

    private static String getSimbolo(String codigo) {
        return switch (codigo) {
            case "BRL" -> "R$";
            case "USD" -> "$";
            case "EUR" -> "€";
            case "GBP" -> "£";
            case "JPY" -> "¥";
            case "ARS" -> "$";
            case "CAD" -> "C$";
            default -> "";
        };
    }
}