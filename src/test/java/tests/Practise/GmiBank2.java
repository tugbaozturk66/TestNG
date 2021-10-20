package tests.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class GmiBank2 extends TestBase{
    @Test
    public void test() throws InterruptedException {
        // 1) https://gmibank.com/ ADRESiNE GiDiN
        // 2) Sign In BUTONUNA TIKLAYIN
        // 3) Sign in EKRANINA GiTTiGiNiZi DOGRULAYIN
        // 3) Sign in EKRANINA GiTTiGiNiZi FARKLI BiR WebElement'i KULLANARAK,2. KEZ DOGRULAYIN
        // 4) VERiLEN KULLANICI ADI VE SiFRE iLE SAYFAYA GiRiS YAPIN (Username: employee32, Password: team32team32-)
        // 5) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI DOGRULAYIN
        // 6) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI FARKLI BiR WEBELEMENT'i KULLANARAK 2. KEZ DOGRULAYIN
        // 7) SAYFADAN CIKIS YAPIN
        // 8) SAYFADAN CIKIS YAPILDIGINI DOGRULAYIN
        // 9) FARKLI BiR WEBELEMENT'i KULLANARAK, SAYFADAN CIKIS YAPILDIGINI 2. KEZ DOGRULAYIN
        driver.get("https://gmibank.com/");

        // 2) Sign In BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//*[span='Sign in']")).click();

        // 3) Sign in EKRANINA GiTTiGiNiZi DOGRULAYIN
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://gmibank.com/login";

        if(driver.getCurrentUrl().equals(expectedUrl)){
            System.out.println("URL Sign in Testi PASS");
        }else {
            System.out.println("URL Sign in Testi FAİLED");
        }

        Thread.sleep(5000);

        // 4) Sign in EKRANINA GiTTiGiNiZi FARKLI BiR WebElement'i KULLANARAK,2. KEZ DOGRULAYIN

        if((driver.findElement(By.xpath("(//span[.='Sign in'])[2]")).getText()).equals("Sign in")){
            System.out.println("URL Sign in Testi PASS");
        } else {
            System.out.println("URL Sign in Testi FAILED");
        }

        // 6) VERiLEN KULLANICI ADI VE SiFRE iLE SAYFAYA GiRiS YAPIN (Username: employee32, Password: team32team32-)

        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("employee32", Keys.TAB);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("team32team32-", Keys.ENTER);

        // 5) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI DOGRULAYIN

        // 6) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI FARKLI BiR WEBELEMENT'i KULLANARAK 2. KEZ DOGRULAYIN
        // 7) SAYFADAN CIKIS YAPIN
        // 8) SAYFADAN CIKIS YAPILDIGINI DOGRULAYIN
        // 9) FARKLI BiR WEBELEMENT'i KULLANARAK, SAYFADAN CIKIS YAPILDIGINI 2. KEZ DOGRULAYIN
    }
}
