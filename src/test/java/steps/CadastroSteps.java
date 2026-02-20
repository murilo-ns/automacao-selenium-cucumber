package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;
import pages.HomePage;
import runner.RunBase;

public class CadastroSteps {

    private WebDriver driver;
    private HomePage homePage;
    private CadastroPage cadastroPage;

    private String nomeValido;
    private String email;
    private String senha;

    @Dado("que estou na tela de cadastro de usuários")
    public void que_estou_na_tela_de_cadastro_de_usuarios() {

        driver = RunBase.getDriver();
        homePage = new HomePage(driver);
        cadastroPage = new CadastroPage(driver);

        nomeValido = "Murilo Teste";
        email = cadastroPage.gerarEmailAleatorio();
        senha = cadastroPage.gerarSenhaAleatoria();

        homePage.acessarHomePage();
        homePage.acessarTelaCadastro();
    }

    @Quando("preencher o formulário de cadastro com dados válidos nos campos obrigatórios")
    public void preencher_o_formulario_de_cadastro_com_dados_validos() {

        cadastroPage.cadastrarNovoUsuario(nomeValido, email, senha);
    }

    @Então("ao submeter os dados recebo a confirmação que os dados foram salvos com sucesso")
    public void ao_submeter_os_dados_recebo_confirmacao() {

        boolean cadastroOk = cadastroPage.validarCadastro(nomeValido);
        Assert.assertTrue("Cadastro não foi confirmado com sucesso", cadastroOk);
    }
}