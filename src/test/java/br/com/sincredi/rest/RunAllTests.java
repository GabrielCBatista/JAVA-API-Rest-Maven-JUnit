package br.com.sincredi.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.sincredi.rest.tests.SimulacoesTests;
import br.com.sincredi.rest.tests.RestricoesTests;
import br.com.sincredi.rest.utils.ValidaMensagem;
import br.com.sincredi.rest.utils.SimulacaoDados;

@RunWith(Suite.class)
@SuiteClasses({
        RestricoesTests.class,
        SimulacoesTests.class,
        ValidaMensagem.class,
        SimulacaoDados.class
})

public class RunAllTests {

}
