package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class RunBase {

    protected static WebDriver driver;

    public enum Browser {
        CHROME
    }

    public static WebDriver getDriver(Browser browser, boolean headless) {

        if (driver == null) {

            switch (browser) {

                case CHROME:

                    ChromeOptions options = new ChromeOptions();

                    if (headless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--window-size=1920,1080");
                    }

                    driver = new ChromeDriver(options);
                    break;

                default:
                    throw new IllegalArgumentException("Browser não suportado: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static WebDriver getDriver() {

        if (driver == null) {

            String browserParam = System.getProperty("browser", "CHROME").toUpperCase();
            Browser browser = Browser.valueOf(browserParam);
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

            getDriver(browser, headless);
        }

        return driver;
    }

    public static void finalizarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}