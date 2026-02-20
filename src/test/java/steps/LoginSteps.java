package steps;

import hooks.Hooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import runner.RunBase;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private String usuario;
    private String senha;

    private boolean loginOk;

    @Dado("que existe um usuário válido no sistema")
    public void que_existe_um_usuario_valido_no_sistema() {
        usuario = Hooks.usuarioCriado;
        senha = Hooks.senhaCriada;
    }

    @Dado("que estou na tela de login")
    public void que_estou_na_tela_de_login() {
        driver = RunBase.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.acessarHomePage();
        homePage.acessarTelaLogin();
    }

    @Quando("realizo o login")
    public void realizo_o_login() {
        loginPage.realizarLogin(usuario, senha);
    }

    @Então("o login deve ser realizado com sucesso")
    public void validar_login_com_sucesso() {
        boolean loginOk = loginPage.validarLogin(usuario);
        Assert.assertTrue("Login não foi realizado com sucesso", loginOk);
    }
}