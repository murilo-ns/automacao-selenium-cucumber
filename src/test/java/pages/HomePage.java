package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {

    private final String url = "https://automationpratice.com.br/";

    private final By iconeFrete = By.cssSelector(".el_feature_box");
    private final By botaoLogin = By.cssSelector("a[href='/login']");
    private final By botaoCadastro = By.cssSelector("a[href='/register']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acessarHomePage() {
        driver.get(url);
        esperarElementoVisivel(iconeFrete);
    }

    public void acessarTelaLogin() {
        clicarNoElemento(botaoLogin);
    }

    public void acessarTelaCadastro() {
        clicarNoElemento(botaoCadastro);
    }
}