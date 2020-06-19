import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.percy.selenium.Percy;

import java.util.concurrent.TimeUnit;


public class TestCase extends Runner{
    @Test
    public void test() throws InterruptedException {
        Percy percy = new Percy(driver);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        driver.get("http://localhost:8001/");
        percy.snapshot("About Us");

        //Thread.sleep(2000);
        driver.findElement(By.linkText("Contact Us!")).click();
        percy.snapshot("Contact Us");
    }
}
