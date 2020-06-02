import com.sun.net.httpserver.HttpServer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public WebDriver driver;
    private static ExecutorService serverExecutor;
    private static HttpServer server;
    @BeforeMethod
    public void setUp() throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/nithyamani/Desktop/chromedrivers/chromedriver83");
        serverExecutor = Executors.newFixedThreadPool(1);
        server = App.startServer(serverExecutor);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        server.stop(1);
        serverExecutor.shutdownNow();
    }
}
