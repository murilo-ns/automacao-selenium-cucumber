# 🚀 Automação de Testes Web

### Selenium + Cucumber + JUnit + Java

![Java](https://img.shields.io/badge/Java-11+-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-Testing-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)

------------------------------------------------------------------------

## 📌 Sobre o Projeto

Este projeto consiste na automação de testes funcionais de uma aplicação
web utilizando **Selenium WebDriver com Cucumber (BDD)**.

A implementação segue boas práticas de engenharia de automação,
incluindo:

-   Page Object Model (POM)
-   Separação clara de responsabilidades
-   Reutilização de código via classes utilitárias
-   Esperas explícitas (WebDriverWait)
-   Estrutura escalável para crescimento do projeto

------------------------------------------------------------------------

## 🏗️ Arquitetura do Projeto

    src
     └── test
         ├── java
         │    ├── pages        → Page Objects
         │    ├── steps        → Definição dos Steps (BDD)
         │    ├── hooks        → Setup e teardown dos testes
         │    ├── runner       → Classe Runner do Cucumber
         │    └── support      → BasePage e Utils
         └── resources
              └── features     → Arquivos .feature
    pom.xml
    README.md

------------------------------------------------------------------------

## 🧠 Estratégia de Automação

### ✔ Page Object Model (POM)

Cada página da aplicação possui uma classe dedicada responsável por:

-   Mapear elementos
-   Encapsular ações
-   Isolar regras de negócio da camada de teste

### ✔ Classe Utils

Centraliza:

-   Esperas explícitas
-   Interações com elementos
-   Validações genéricas
-   Tratamento de popups (SweetAlert2)

### ✔ Cucumber (BDD)

Exemplo de cenário:

``` gherkin
Scenario: Login com sucesso
  Given que existe um usuário válido no sistema
  And que estou na tela de login
  When realizo o login
  Then o login deve ser realizado com sucesso
```

------------------------------------------------------------------------

## 🧪 Cenários Automatizados

-   Cadastro de usuário
-   Login com sucesso
-   Validação de mensagens de confirmação
-   Validação de mensagem de boas-vindas
-   Tratamento de popup SweetAlert2

------------------------------------------------------------------------

## ▶️ Como Executar os Testes

### 🔹 IntelliJ

1.  Abrir o projeto
2.  Navegar até a classe Runner
3.  Clicar com o botão direito
4.  Selecionar Run

### 🔹 Maven

    mvn clean test

------------------------------------------------------------------------

## 🔧 Pré-requisitos

-   Java 11 ou superior
-   Maven instalado
-   Navegador Chrome
-   ChromeDriver compatível
-   IntelliJ IDEA (recomendado)

------------------------------------------------------------------------

## 📈 Boas Práticas Aplicadas

-   Uso de WebDriverWait
-   Código organizado em camadas
-   Separação entre ações e validações
-   Métodos reutilizáveis
-   Tratamento adequado de popups

------------------------------------------------------------------------

## 🎯 Objetivo Profissional

Projeto desenvolvido com foco em:

-   Consolidação de fundamentos em automação web
-   Aplicação prática de BDD
-   Estruturação profissional de projeto
-   Construção de portfólio para QA Automation Engineer

------------------------------------------------------------------------

## 👨‍💻 Autor

Murilo\
QA Automation Engineer
