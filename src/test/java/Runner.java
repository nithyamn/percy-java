import com.sun.net.httpserver.HttpServer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public WebDriver driver;
    private static ExecutorService serverExecutor;
    private static HttpServer server;
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void setUp() throws IOException {
        //Run tests locally
        System.setProperty("webdriver.chrome.driver", "/Users/nithyamani/Desktop/chromedrivers/chromedriver83");
        driver = new ChromeDriver();

        //Start localhost on port 8001
        serverExecutor = Executors.newFixedThreadPool(1);
        server = App.startServer(serverExecutor);

        //Run tests on BrowserStack
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "81.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "Percy");
        caps.setCapability("name", "visual_test");
        caps.setCapability("browserstack.local", "true");

        driver = new RemoteWebDriver(new URL(URL), caps);*/
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        //server.stop(1);
        //serverExecutor.shutdownNow();
    }
}
