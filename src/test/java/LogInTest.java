import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void logITestValidCredential()
    {
    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        String pageTitle = driver.getTitle();

        Assert.assertNotEquals(pageTitle, "OrangeHRM");
    }

//    public void logOut(){
//    driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
//    driver.findElement(By.xpath("//p[normalize-space()='Logout']")).click();
//
//
//    }

    @AfterTest
    public void tearDown() throws InterruptedException
    {

    driver.quit();
    }
}
