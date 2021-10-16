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

public class C04_HepsiBurada {
    //https://www.hepsiburada.com/
    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1.“https://www.hepsiburada.com/” Adresine gidin
    //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.hepsiburada.com/");

    }
    @Test
    public void test1(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"),"title istenen metni icermiyor");


driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='category-suggestion-title']"));
        System.out.println(sonucYazisi.getText());
        softAssert.assertTrue(sonucYazisi.getText().contains("araba"),"sonuc araba icermiyor");
softAssert.assertFalse(sonucYazisi.getText().contains("oto"),"sonuc oto iceriyor");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
