package tests.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class GmiBank extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //// 1) https://gmibank.com/ ADRESiNE GiDiN
        driver.get("https://gmibank.com/");
        //// 2) Sign In BUTONUNA TIKLAYIN
        Thread.sleep(8000);
        WebElement dropDown=driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]"));
        dropDown.click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();


        //// 3) USERNAME "deneme@gmi.bank.com", PASSWORD "Deneme44" KULLANARAK GiRiS YAPIN
        WebElement signIn=driver.findElement(By.xpath("//input[@name='username']"));
        signIn.sendKeys("deneme@gmi.bank.com");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Deneme44");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(5000);
        //// 4) SAYFAYA YANLIS SiFRE VE PASSWORD iLE GiRiS YAPILAMADIGINI DOGRULAYIN
        //// 5) SAYFAYA YANLIS SiFRE VE PASSWORD iLE GiRiS YAPILAMADIGINI
        ////    FARKLI BiR WEBELEMENT KULLANARAK 2. KEZ DOGRULAYIN
        //// <div role="alert" class="Toastify__toast-body">translation-not-found[error.http.401]</div>
    }
}
