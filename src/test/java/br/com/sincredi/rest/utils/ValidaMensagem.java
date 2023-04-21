package br.com.sincredi.rest.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

import static org.junit.Assert.*;

public class ValidaMensagem {

    public static void validarTipoCadastro(Response response) {
        JsonPath json = response.jsonPath();
        Object obj = json.getList("");

        if (obj instanceof List) {
            List<Map<String, ?>> simulacoes = (List<Map<String, ?>>) obj;

            for (Map<String, ?> simulacao : simulacoes) {
                Set<String> camposEsperados = new HashSet<>(Arrays.asList("nome", "cpf", "email", "valor", "parcelas", "seguro"));
                Set<String> camposRecebidos = simulacao.keySet();
                assertEquals(camposEsperados, camposRecebidos);
                assertEquals(String.class.getSimpleName(), simulacao.get("nome").getClass().getSimpleName());
                assertEquals(String.class.getSimpleName(), simulacao.get("cpf").getClass().getSimpleName());
                assertEquals(String.class.getSimpleName(), simulacao.get("email").getClass().getSimpleName());
                assertTrue(simulacao.get("valor") instanceof Number);
                assertTrue(simulacao.get("parcelas") instanceof Integer);
                assertTrue(simulacao.get("seguro") instanceof Boolean);
            }
        } else {
            throw new RuntimeException("Resposta inválida: esperado um array JSON, mas foi recebido um objeto JSON");
        }
    }
    public static void validarCadastroSimulacao(Response response) {
        Map<String, ?> simulacao = response.jsonPath().getMap("");
        Set<String> camposEsperados = new HashSet<>(Arrays.asList("nome", "cpf", "email", "valor", "parcelas", "seguro"));
        Set<String> camposRecebidos = simulacao.keySet();
        assertEquals(camposEsperados, camposRecebidos);
        assertEquals(String.class, simulacao.get("nome").getClass());
        assertEquals(String.class, simulacao.get("cpf").getClass());
        assertEquals(String.class, simulacao.get("email").getClass());
        assertTrue(simulacao.get("valor") instanceof Number);
        assertTrue(simulacao.get("parcelas") instanceof Integer);
        assertTrue(simulacao.get("seguro") instanceof Boolean);
    }


    public static void validarMensagemFaltaInformacoes(Response response, List<String> camposFaltantes) {
        String mensagem = response.jsonPath().getString("erros");

        for (String campo : camposFaltantes) {
            assertTrue(mensagem.contains(campo));
        }
    }
    public static void validarTipoMensagem(Response response) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("mensagem");

        assertTrue(mensagem instanceof String);
    }

    public static void validarTipoMensagem1(Response response, String cpf) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("mensagem");

        String mensagemEsperada = "O CPF " + cpf + " possui restrição";
        assertEquals(mensagemEsperada, mensagem);
    }

    public static void validarTipoMensagem2(Response response) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("mensagem");

        String mensagemEsperada = "CPF não encontrado";
        assertEquals(mensagemEsperada, mensagem);
    }

    public static void validarTipoMensagemDeletada1(Response response) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("string");

        String mensagemEsperada = "";
        assertEquals(mensagemEsperada, mensagem);
        System.out.println("Mensagem esperada: " + mensagemEsperada);
        System.out.println("Mensagem recebida: " + mensagem);
    }

    public static void validarTipoMensagemDeletada2(Response response) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("string");

        String mensagemEsperada = "Simulação deletada com sucesso";
        assertEquals(mensagemEsperada, mensagem);
        System.out.println("Mensagem esperada: " + mensagemEsperada);
        System.out.println("Mensagem recebida: " + mensagem);
    }

    public static void validarTipoMensagemCpfJaExistente(Response response) {
        JsonPath json = response.jsonPath();
        String mensagem = json.getString("mensagem");

        String mensagemEsperada = "CPF já existente";
        assertEquals(mensagemEsperada, mensagem);
    }

    public static void validarTipoDelete(Response response) {
        String mensagem = response.getBody().asString();
        Assert.assertEquals("OK", mensagem);
    }
}
