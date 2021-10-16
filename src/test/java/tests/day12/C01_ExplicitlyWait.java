package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void implicitlyWaitTest(){
        //1. Bir class olusturun : C01_WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //  Iki metod icin de asagidaki adimlari test edin.

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
//driver.findElement(By.xpath("//button[text()='Remove']"));

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());
        softAssert.assertAll();

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement sonucYazisi2=driver.findElement(By.xpath("//p[@id='message']"));
        //sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));// seklinde yeniden de atayabiliriz.
        Assert.assertTrue(sonucYazisi2.isDisplayed());
    }
    @Test
    public void explicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //driver.findElement(By.xpath("//button[text()='Remove']"));

        WebDriverWait wait=new WebDriverWait(driver,15);
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        //1 yol explicitly wait'i istersek locate islemi ile birlikte yapabiliriz
        WebElement yaziLocateIleBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziLocateIleBirlikte.isDisplayed());

        //2.yolveya once locate edip uygun method kullanarak beklemeyi yaptirabiliriaz
       /* WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed(),"sonuc yazisi gorunmuyor");*/
    // bu test icin 2. yolu kullanamiyoruz

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBaskLocatedIle=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[@id='message']"))));
        Assert.assertTrue(itsBaskLocatedIle.isDisplayed());
    }
}
