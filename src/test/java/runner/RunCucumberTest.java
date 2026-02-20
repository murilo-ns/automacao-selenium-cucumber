package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty"}
)

public class RunCucumberTest extends RunBase {

    @BeforeClass
    public static void start() {

        String browserParam = System.getProperty("browser", "CHROME").toUpperCase();
        Browser browser = Browser.valueOf(browserParam);

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        getDriver(browser, headless);
    }

    @AfterClass
    public static void stop() {
        finalizarDriver();
    }
}