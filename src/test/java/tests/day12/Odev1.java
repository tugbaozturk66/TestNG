package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Odev1 extends TestBase {
    //1. Bir class olusturun : EnableTest

    @Test
    //2. Bir metod olusturun : isEnabled()
    public void isEnable(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"textbox etkin");
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enabledYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(enabledYazisi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        softAssert.assertTrue(textBox.isEnabled());
        softAssert.assertAll();

    }
}
