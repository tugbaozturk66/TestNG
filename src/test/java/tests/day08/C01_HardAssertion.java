package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
    //amazon sayfasina gidin
    //url nin amazon icerdigini test edin
    //title nin amazon icerdigini test edin
    //java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void test1() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon"));
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    Assert.assertTrue(ilkUrun.getText().contains("Java"));

    }
    @AfterClass
    public void tearDown(){
driver.close();
    }

}
