import com.sun.net.httpserver.HttpServer;
import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

public class AuthSample{
    public WebDriver driver;
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "81.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "Percy");
        caps.setCapability("name", "visual_auth_test");

        driver = new RemoteWebDriver(new URL(URL), caps);

        Percy percy = new Percy(driver);

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        percy.snapshot("Basic Auth check 1");
        Thread.sleep(2000);

        percy.snapshot("Basic Auth check 2");
        driver.getTitle();
        driver.quit();
    }
}
