package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Odev_DropDown {
    ////Bir class oluşturun: C3_DropDownAmazon
    //// https://www.amazon.com/ adresine gidin.
    ////- Test 1
    ////Arama kutusunun yanindaki kategori menusundeki kategori
    ////sayisinin 45 oldugunu test edin
    ////-Test 2
    ////1. Kategori menusunden Books secenegini secin
    ////2. Arama kutusuna Java yazin ve aratin
    ////3. Bulunan sonuc sayisini yazdirin
    ////4. Sonucun Java kelimesini icerdigini test edin
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void test1(){
        WebElement dropDown= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select= new Select(dropDown);
        List<WebElement> kategoriler= select.getOptions();
        System.out.println("kategori sayisi: "+kategoriler.size());
        Assert.assertEquals(kategoriler.size(),45,"kategori sayisi 45 degil");
    }
    @Test
    public void test2() throws InterruptedException {
        WebElement dropDown= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select= new Select(dropDown);
        select.selectByVisibleText("Books");
        Thread.sleep(3000);
       WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       searchBox.sendKeys("Java"+ Keys.ENTER);
       WebElement sonucYazdir=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazdir.getText());
        Assert.assertTrue(sonucYazdir.getText().contains("Java"),"Java icermiyor");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

