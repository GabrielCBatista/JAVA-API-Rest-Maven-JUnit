<h1 align="center"> Prova técnica API </h1>

## Não possui restrição - Teste Aprovado

Conforme a documentação técnica da aplicação:
* Se não possui restrição do HTTP Status 204 é retornado

Conforme o swagger:
* Não possui restrição Code 204

Diretorio br/com/sincredi/rest/tests/RestricoesTests.java
* Teste public void testNãoPossuiRestrição

## Evidência:

##### HTTP/1.1 204

----------------------------------------------------------

## Pessoa com restrição - Teste Reprovado

Conforme a documentacão técnica da aplicação:
* Se possui restrição o HTTP Status 200 é retornado com a mensagem "O CPF 99999999999 possui restrição"

Conforme o swagger:
* Pessoa com restrição Code 200
* "mensagem": "O CPF 999999999 possui restrição"

Diretorio br/com/sincredi/rest/tests/RestricoesTests.java
* Teste public void testCpfComRestricao

## Evidência:
##### Expected :O CPF 97093236014 possui restrição
##### Actual   :O CPF 97093236014 tem problema

----------------------------------------------------------

## Simulações encontradas - Teste Reprovado

Conforme a documentação técnica da aplicação:
* Este endpoint é responsável por inserir uma nova simulação.

Conforme o swagger:
* Simulações encontradas Code 200
* {
nome*	string
cpf*	string
email*	string
valor*	number
parcelas*	integer($int32)
seguro*	boolean
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testSimulaçõesEncontradas

## Evidência:
##### Expected :[parcelas, seguro, cpf, valor, nome, email]
##### Actual   :[parcelas, seguro, cpf, valor, nome, id, email]

----------------------------------------------------------

## Simulação criada com sucesso - Teste Reprovado

Conforme a documentação técnica da aplicação:
* Uma simulação cadastrada com sucesso retorna o HTTP Status 201 e os dados inseridos como retorno

Conforme o swagger:
* Simulação criada com sucesso Code 201
* {
"nome": "Fulano de Tal",
"cpf": 97093236014,
"email": "email@email.com",
"valor": 1200,
"parcelas": 3,
"seguro": true
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testSimulaçãoCriadaComSucesso

## Evidência:
##### Expected :[parcelas, seguro, cpf, valor, nome, email]
##### Actual   :[parcelas, seguro, cpf, valor, nome, id, email]

----------------------------------------------------------

## Falta de informações - Aprovado

Conforme a documentação técnica da aplicação:
* Uma simulação com problema em alguma regra retorna o HTTP Status 400 com a lista de erros

Conforme o swagger:
* Falta de informações Code 400
* {
"erros": {
"additionalProp1": "string",
"additionalProp2": "string",
"additionalProp3": "string"
}
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testFaltaDeInformacoes

## Evidência:
##### {
##### "erros": {
##### "cpf": "CPF não pode ser vazio",
##### "email": "E-mail não deve ser vazio"
##### }
##### }

----------------------------------------------------------

## CPF já existente - Teste Reprovado

Conforme a documentacão técnica da aplicação:
* Uma simulação para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF já existente"

Conforme o swagger:
* CPF já existente Code 409

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void TestCpfJáExistente

## Evidência:
##### Expected status code <409> but was <400>.
##### Expected :CPF já existente
##### Actual   :CPF duplicado

----------------------------------------------------------

## Simulação encontrada - Teste Reprovado


Conforme a documentação técnica da aplicação:
* A alteração pode ser feita em qualquer atributo da simulação

Conforme o swagger:
* Simulação encontrada Code 200
* {
"nome": "Fulano de Tal",
"cpf": 97093236014,
"email": "email@email.com",
"valor": 1200,
"parcelas": 3,
"seguro": true
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testSimulaçãoEncontrada()

## Evidência:
##### Expected :[parcelas, seguro, cpf, valor, nome, email]
##### Actual   :[parcelas, seguro, cpf, valor, nome, id, email]

----------------------------------------------------------

## Simulação não encontrada - Teste Reprovado


Conforme a documentação técnica da aplicação:
* Se o CPF não possuir uma simulação o HTTP Status 404 é retornado com a mensagem "CPF não encontrado"

Conforme o swagger:
* Simulação não encontrada Code 404
* {
"mensagem": "O CPF 999999999 possui restrição"
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste  public void testSimulacaoNaoEncontrada

## Evidência:
##### Expected :CPF não encontrado
##### Actual   :CPF 48189438022 não encontrado

----------------------------------------------------------

## Simulação alterada com sucesso - Teste reprovado

Conforme a documentação técnica da aplicação:
* A alteração pode ser feita em qualquer atributo da simulação
* As mesmas regras se mantém

Conforme o swagger:
* Simulação alterada com sucesso Code 200
* {
"nome": "Fulano de Tal",
"cpf": 97093236014,
"email": "email@email.com",
"valor": 1200,
"parcelas": 3,
"seguro": true
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste  public void testSimulaçãoAlteradaComSucesso

## Evidência:
##### Permite um Cpf restrito
##### Expected :[parcelas, seguro, cpf, valor, nome, email]
##### Actual   :[parcelas, seguro, cpf, valor, nome, id, email]

----------------------------------------------------------

## Simulação não encontrada - Teste Reprovado

Conforme a documentação técnica da aplicação:
* Se o CPF não possuir uma simulação o HTTP Status 404 é retornado com a mensagem "CPF não encontrado"

Conforme o swagger:
* Simulação não encontrada Code 404
* {
"mensagem": "O CPF 999999999 possui restrição"
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testSimulaçãoNãoEncontrada

## Evidência:
##### Expected :CPF não encontrado
##### Actual   :CPF 48189438022 não encontrado

----------------------------------------------------------

## CPF já existente - Teste Reprovado

Conforme a documentação técnica da aplicação:
* Uma simulação para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF já existente"

Conforme o swagger:
* CPF já existente Code 409
* {
"mensagem": "O CPF 999999999 possui restrição"
}

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testCpfJaExistente

## Evidência:
##### Expected status code <409> but was <400>
##### Expected :CPF já existente
##### Actual   :CPF duplicado

----------------------------------------------------------

## Simulação removida com sucesso - Teste Reprovado

Conforme a documentacão técnica da aplicação:
* Retorna o HTTP Status 204 se simulação for removida com sucesso

Conforme o swagger:
* Simulação removida com sucesso Code 200
* "string"

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void testSimulaçãoRemovidaComSucesso

Evidência:
##### Expected :
##### Actual   :OK
##### Expected status code <204> but was <200>

----------------------------------------------------------

## Simulação removida com sucesso - Teste Reprovado

Conforme a documentacão técnica da aplicação:
* Retorna o HTTP Status 404 com a mensagem "Simulação não encontrada" se não existir a simulação pelo ID informado

Conforme o swagger:
* Simulação removida com sucesso Code 200
* "string"

Diretorio src/test/java/br/com/sincredi/rest/tests/SimulacoesTests.java
* Teste public void public void testSimulaçãoRemovidaNãoEncontrada

Evidência:
##### Expected :Simulação não encontrada
##### Actual   :OK
##### Expected status code <404> but was <200>
