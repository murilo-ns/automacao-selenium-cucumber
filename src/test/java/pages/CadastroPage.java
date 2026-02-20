package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class CadastroPage extends Utils {

    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoCadastrar = By.id("btnRegister");

    private By elementoFraseConfirmacao = By.id("swal2-title");
    private By mensagemBemVindo = By.id("swal2-html-container");
    private By botaoOkPopUP = By.className("swal2-styled");

    private final String fraseConfirmacaoEsperada = "Cadastro realizado!";

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    public void cadastrarNovoUsuario(String nome, String email, String senha) {
        preencherCampo(campoNome, nome);
        preencherCampo(campoEmail, email);
        preencherCampo(campoSenha, senha);
    }

    public boolean validarCadastro(String nome) {
        clicarNoElemento(botaoCadastrar);

        boolean mensagemOk = validarTextoIndicativoDaTela(elementoFraseConfirmacao, fraseConfirmacaoEsperada);
        boolean bemVindoOk = validarMensagemBemVindo(mensagemBemVindo, nome);

        clicarNoElemento(botaoOkPopUP);

        return mensagemOk && bemVindoOk;
    }
}