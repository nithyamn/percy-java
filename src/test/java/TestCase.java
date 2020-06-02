import org.testng.annotations.Test;
import io.percy.selenium.Percy;


public class TestCase extends Runner{
    @Test
    public void test() throws InterruptedException {
        Percy percy = new Percy(driver);
        driver.get("http://localhost:8001/");
        percy.snapshot("Sample Website");
        Thread.sleep(2000);
    }
}
