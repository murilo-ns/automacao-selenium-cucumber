package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class RunBase {

    private static WebDriver driver;

    public enum Browser {
        CHROME, FIREFOX
    }

    public static WebDriver getDriver() {
        String browserParam = System.getProperty("browser", "CHROME").toUpperCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        return getDriver(Browser.valueOf(browserParam), headless);
    }

    public static WebDriver getDriver(Browser browser, boolean headless) {

        if (driver == null) {
            String projectPath = System.getProperty("user.dir");

            switch (browser) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    if (headless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(options);
                    break;

                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--width=1920");
                        firefoxOptions.addArguments("--height=1080");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
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