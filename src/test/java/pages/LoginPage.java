package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class LoginPage extends Utils {

    private final By campoUsuario = By.id("user");
    private final By campoSenha = By.id("password");
    private final By botaoLogin = By.id("btnLogin");

    private By elementoFraseConfirmacao = By.id("swal2-title");
    private By mensagemBemVindo = By.id("swal2-html-container");
    private By botaoOkPopUP = By.className("swal2-styled");
    private final String fraseConfirmacaoEsperada = "Login realizado";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void realizarLogin(String usuario, String senha) {
        preencherCampo(campoUsuario, usuario);
        preencherCampo(campoSenha, senha);
    }
    public boolean validarLogin(String nome) {
        clicarNoElemento(botaoLogin);

        boolean mensagemOk = validarTextoIndicativoDaTela(elementoFraseConfirmacao, fraseConfirmacaoEsperada);
        boolean bemVindoOk = validarMensagemBemVindo(mensagemBemVindo, nome);

        clicarNoElemento(botaoOkPopUP);

        return mensagemOk && bemVindoOk;
    }
}