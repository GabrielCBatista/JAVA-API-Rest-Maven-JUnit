package br.com.sincredi.rest.utils;

import java.util.HashMap;
import java.util.Map;

public class SimulacaoDados {
    public static Map<String, Object> obterSimulacaoDadosExemplo1() {
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Goku");
        dados.put("cpf", "36154778055");
        dados.put("email", "goku@dragonball.com");
        dados.put("valor", 11000);
        dados.put("parcelas", 3);
        dados.put("seguro", true);

        return dados;
    }

    public static Map<String, Object> obterSimulacaoDadosExemplo2() {
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Vegeta");
        dados.put("cpf", "97093236014");
        dados.put("email", "vegeta@dragonball.com");
        dados.put("valor", 20000);
        dados.put("parcelas", 5);
        dados.put("seguro", false);

        return dados;
    }

    public static Map<String, Object> obterSimulacaoDadosExemplo3() {
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Gohan");
        dados.put("cpf", "48189438022");
        dados.put("email", "gohan@dragonball.com");
        dados.put("valor", 1200);
        dados.put("parcelas", 3);
        dados.put("seguro", true);

        return dados;
    }
    public static Map<String, Object> obterSimulacaoDadosExemplo4() {
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Piccolo");
        dados.put("cpf", "36154778055");
        dados.put("email", "piccolo@dragonball.com");
        dados.put("valor", 1200);
        dados.put("parcelas", 3);
        dados.put("seguro", true);

        return dados;
    }
    public static Map<String, Object> obterSimulacaoDadosExemplo5() {
        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Kuririn");
        dados.put("cpf", "40776465090");
        dados.put("email", "kuririn@dragonball.com");
        dados.put("valor", 5000);
        dados.put("parcelas", 6);
        dados.put("seguro", false);

        return dados;
    }

}

