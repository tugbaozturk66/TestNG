package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class C01_Allerts {
    //● Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının    “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
WebDriver driver;
@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
@Test
    public void acceptAllert(){
  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
  driver.switchTo().alert().accept();
  WebElement resultYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
String expectedResult="You successfully clicked an alert";
String actualResult=resultYazisiElementi.getText();
    Assert.assertEquals(actualResult,expectedResult,"sonuc yazisi istenen metni icermiyor");
}
    @Test
    public void dismissAlert(){
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
driver.switchTo().alert().dismiss();
    WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='result']"));
String istenmeyenSonuc="successfully";
String actualSonuc=sonucYazisi.getText();
assertFalse("result yazisi istenmeyen kelimeyi iceriyor",actualSonuc.contains(istenmeyenSonuc));

    }


    @Test
    public void sendKeysAlert(){
driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
String isim="Mehmet";
driver.switchTo().alert().sendKeys(isim);
driver.switchTo().alert().accept();
WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='result']"));
String actualResult=sonucYazisi.getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualResult.contains(isim));
        softAssert.assertAll();
}
@AfterClass
    public void tearDown(){
driver.close();
}

}
