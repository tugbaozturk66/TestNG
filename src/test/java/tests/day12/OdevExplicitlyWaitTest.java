package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class OdevExplicitlyWaitTest extends TestBase {
    @Test
    //2. Bir metod olusturun : enableTest()
    public void enableTest(){
        // 3. https://demoqa.com/dynamic-properties adresine gidin.
       driver.get("https://demoqa.com/dynamic-properties");
        // 4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement willEnable=driver.findElement(By.xpath("//button[@id='enableAfter']"));
        Assert.assertFalse(willEnable.isEnabled(),"will enable etkin");
        //5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait=new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.elementToBeClickable(willEnable));
        Assert.assertTrue(willEnable.isEnabled());

    }
    // 6. Bir metod olusturun : visibleTest()
    @Test
    public void visibleTest(){
        // 7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun
        //gorunmesini bekleyin, ve gorunur oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        //WebElement visibleAfter=driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement buttonAktif=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        Assert.assertTrue(buttonAktif.isEnabled(),"visible butonuna ulasilamiyor");

    }
}
