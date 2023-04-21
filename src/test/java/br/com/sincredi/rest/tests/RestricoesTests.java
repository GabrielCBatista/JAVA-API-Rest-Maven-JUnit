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


public class RestricoesTests extends BaseTest {
    @Test
    public void testNãoPossuiRestrição() {
        Map<String, Object> simulacaoDados = SimulacaoDados.obterSimulacaoDadosExemplo1();
        String cpf = (String) ((Map<?, ?>) simulacaoDados).get("cpf");

        Response response = given()
                .pathParam("cpf", cpf)
                .when()
                .get("/restricoes/{cpf}")
                .then()
                .statusCode(204)
                .log().all()
                .extract().response();

    }
    @Test
    public void testCpfComRestricao() {
        Map<String, Object> simulacaoDados = SimulacaoDados.obterSimulacaoDadosExemplo2();
        String cpf = (String) ((Map<?, ?>) simulacaoDados).get("cpf");

        Response response = given()
                .pathParam("cpf", cpf)
                .when()
                .get("/restricoes/{cpf}")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        ValidaMensagem.validarTipoMensagem1(response, cpf);
    }
}

