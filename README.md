<<<<<<< HEAD
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
=======
# desafio-automacao-de-testes-api



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/GabrielCBatista/desafio-automacao-de-testes-api.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/GabrielCBatista/desafio-automacao-de-testes-api/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thank you to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README
Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
>>>>>>> d58c0d1455496c62480ed78c3c98b153977ceafb
