package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {
    //amazon sayfasina gidin
    //url nin amazon icerdigini test edin
    //title nin amazon icerdigini test edin
    //java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini softAssertion ile test edin
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
    public void test1(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("Amazon"),"url amazon icermiyor");
softAssert.assertTrue(driver.getTitle().contains("amazon"),"baslik amazon icermiyor");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    softAssert.assertTrue(ilkUrun.getText().contains("Java"),"urun aciklamasi java icermiyor");
    softAssert.assertAll();
    //fail olsa bile soft assertionda kodlar calismaya devam eder.bu assertAll a kadar bu is boyle devam eder.
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
