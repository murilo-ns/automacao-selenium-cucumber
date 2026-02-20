package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;
import pages.HomePage;
import runner.RunBase;

public class Hooks {

    public static String usuarioCriado;
    public static String senhaCriada;

    @Before("@login")
    public void criarUsuarioValido() {

        WebDriver driver = RunBase.getDriver();

        HomePage homePage = new HomePage(driver);
        CadastroPage cadastroPage = new CadastroPage(driver);

        String nome = "Murilo Teste";
        usuarioCriado = cadastroPage.gerarEmailAleatorio();
        senhaCriada = cadastroPage.gerarSenhaAleatoria();

        homePage.acessarHomePage();
        homePage.acessarTelaCadastro();

        cadastroPage.cadastrarNovoUsuario(nome, usuarioCriado, senhaCriada);
        cadastroPage.validarCadastro(nome);
    }

    @After
    public void finalizarCenario() {
        RunBase.finalizarDriver();
    }
}