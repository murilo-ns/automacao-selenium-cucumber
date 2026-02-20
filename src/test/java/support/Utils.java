package support;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.*;

public class Utils extends BasePage {

    private static final int TEMPO_PADRAO = 20;

    public Utils(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait getWait(int tempo) {
        return new WebDriverWait(driver, Duration.ofSeconds(tempo));
    }

    public WebElement esperarElementoClicavel(By elemento, int tempo) {
        return getWait(tempo)
                .until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public WebElement esperarElementoClicavel(By elemento) {
        return esperarElementoClicavel(elemento, TEMPO_PADRAO);
    }

    public WebElement esperarElementoVisivel(By elemento, int tempo) {
        return getWait(tempo)
                .until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public WebElement esperarElementoVisivel(By elemento) {
        return esperarElementoVisivel(elemento, TEMPO_PADRAO);
    }

    public void clicarNoElemento(By elemento) {
        WebElement el = esperarElementoClicavel(elemento);

        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", el);
        }
    }

    public void preencherCampo(By elemento, String conteudo) {
        WebElement campo = esperarElementoVisivel(elemento);
        campo.clear();
        campo.sendKeys(conteudo);
    }

    protected String extrairTexto(By elemento) {
        WebElement el = esperarElementoVisivel(elemento);
        String texto = el.getText();
        return texto == null ? "" : texto.trim();
    }

    public boolean validarTextoIndicativoDaTela(By elemento, String textoEsperado) {
        String textoReal = extrairTexto(elemento);
        return textoReal.equalsIgnoreCase(textoEsperado.trim());
    }

    public boolean validarMensagemBemVindo(By elemento, String nome) {
        String textoReal = extrairTexto(elemento);
        return textoReal.contains(nome);
    }

    public String gerarEmailAleatorio() {
        return "usuario_teste" + UUID.randomUUID().toString().substring(0,8)
                + "@teste.com.br";
    }

    public String gerarSenhaAleatoria() {

        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiais = "!@#$%&*";

        Random random = new Random();
        List<Character> caracteres = new ArrayList<>();

        caracteres.add(letrasMaiusculas.charAt(random.nextInt(letrasMaiusculas.length())));
        caracteres.add(letrasMinusculas.charAt(random.nextInt(letrasMinusculas.length())));
        caracteres.add(numeros.charAt(random.nextInt(numeros.length())));
        caracteres.add(especiais.charAt(random.nextInt(especiais.length())));

        String todos = letrasMaiusculas + letrasMinusculas + numeros + especiais;

        while (caracteres.size() < 8) {
            caracteres.add(todos.charAt(random.nextInt(todos.length())));
        }

        Collections.shuffle(caracteres);

        StringBuilder senha = new StringBuilder();
        for (char c : caracteres) {
            senha.append(c);
        }

        return senha.toString();
    }
}