import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInTest {
   public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
   public WebDriver driver;

   @BeforeTest
    public void setUp()
    {
        System.out.println("Before Test executed");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void logITestValidCredential()
    {
    driver.findElement(By.xpath("//input").sendKeys("Admin"));

    }

    @AfterTest
    public void tearDown() throws InterruptedException
    {


    }
}
