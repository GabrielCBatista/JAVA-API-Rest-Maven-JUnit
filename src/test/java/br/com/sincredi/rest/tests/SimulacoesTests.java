package br.com.sincredi.rest.tests;

import static br.com.sincredi.rest.utils.SimulacaoDados.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import br.com.sincredi.rest.utils.SimulacaoDados;
import br.com.sincredi.rest.utils.ValidaMensagem;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import br.com.sincredi.rest.core.BaseTest;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimulacoesTests extends BaseTest {

    private static int simulacaoId;
    @Test
    public void testSimulaçõesEncontradas() {
        Response response = given()
                .when()
                .get("/simulacoes")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        ValidaMensagem.validarTipoCadastro(response);
    }
    @Test
    public void testSimulaçãoCriadaComSucesso() {

        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo1();

        Response response = given()
                .and()
                .body(dados)
                .when()
                .post("/simulacoes")
                .then()
                .statusCode(201)
                .log().all()
                .extract()
                .response();

        int simulacaoId = response.jsonPath().getInt("id");

        ValidaMensagem.validarCadastroSimulacao(response);
    }
    @Test
    public void testFaltaDeInformacoes() {
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo3();
        dados.remove("email");
        dados.remove("cpf");

        Response response = given()
                .and()
                .body(dados)
                .when()
                .post("/simulacoes")
                .then()
                .statusCode(400)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarMensagemFaltaInformacoes(response, Arrays.asList("cpf", "email"));
    }
    @Test
    public void TestCpfJáExistente() {
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo1();

        Response response = given()
                .and()
                .body(dados)
                .when()
                .post("/simulacoes")
                .then()
                .statusCode(409)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarTipoMensagemCpfJaExistente(response);
    }
    @Test
    public void testSimulaçãoEncontrada() {
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo1();
        String cpf = (String) dados.get("cpf");

        Response response = given()
                .when()
                .get("/simulacoes/{cpf}", cpf)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarCadastroSimulacao(response);
    }
    @Test
    public void testSimulacaoNaoEncontrada() {
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo3();
        String cpf = (String) dados.get("cpf");

        Response response = given()
                .when()
                .get("/simulacoes/{cpf}", cpf)
                .then()
                .statusCode(404)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarTipoMensagem2(response);
    }
    @Test
    public void testSimulaçãoAlteradaComSucesso() {
        Map<String, Object> dadosSimulacao = SimulacaoDados.obterSimulacaoDadosExemplo1();
        String cpf = (String) dadosSimulacao.get("cpf");
        dadosSimulacao.put("nome", SimulacaoDados.obterSimulacaoDadosExemplo2().get("nome"));
        dadosSimulacao.put("email", SimulacaoDados.obterSimulacaoDadosExemplo2().get("email"));
        dadosSimulacao.put("cpf", SimulacaoDados.obterSimulacaoDadosExemplo2().get("cpf"));

        Response response = given()
                .body(dadosSimulacao)
                .when()
                .put("/simulacoes/{cpf}", cpf)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarCadastroSimulacao(response);
    }
    @Test
    public void testSimulaçãoNãoEncontrada() {
        Map<String, Object> dadosSimulacao = SimulacaoDados.obterSimulacaoDadosExemplo3();
        String cpf = (String) dadosSimulacao.get("cpf");
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo3();
        dadosSimulacao.putAll(dados);

        Response response = given()
                .body(dadosSimulacao)
                .when()
                .put("/simulacoes/{cpf}", cpf)
                .then()
                .statusCode(404)
                .log().all()
                .extract()
                .response();
        ValidaMensagem.validarTipoMensagem2(response);
    }
    @Test
    public void testCpfJaExistente() {
        // Cadastra uma simulação existente para o CPF
        given()
                .body(SimulacaoDados.obterSimulacaoDadosExemplo5())
                .when()
                .post("/simulacoes");

        Map<String, Object> dadosSimulacaoExistente = SimulacaoDados.obterSimulacaoDadosExemplo5();
        String cpf = (String) dadosSimulacaoExistente.get("cpf");
        Map<String, Object> dados = SimulacaoDados.obterSimulacaoDadosExemplo1();
        dadosSimulacaoExistente.putAll(dados);

        Response response = given()
                .body(dadosSimulacaoExistente)
                .when()
                .put("/simulacoes/{cpf}", cpf)
                .then()
                .statusCode(409)
                .log().all()
                .extract()
                .response();

        ValidaMensagem.validarTipoMensagemCpfJaExistente(response);
    }
    @Test
    public void testSimulaçãoRemovidaComSucesso() {
        Response response = given()
                .when()
                .delete("simulacoes/{id}", simulacaoId)
                .then()
                .statusCode(204)
                .log().all()
                .extract()
                .response();
        ValidaMensagem.validarTipoMensagemDeletada1(response);
    }
    @Test
    public void testSimulaçãoRemovidaNãoEncontrada() {
        Response response = given()
                .when()
                .delete("simulacoes/{id}", 99)
                .then()
                .statusCode(404)
                .log().all()
                .extract()
                .response();
        ValidaMensagem.validarTipoMensagemDeletada2(response);
    }
}