package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
    //● Tests package’inda yeni bir class olusturun: C04_WindowHandle

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYaziElementi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="Opening a new window";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualYaziElementi,expectedYazi,"yazi istendigi gibi degil");
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");
        //● Click Here butonuna basın.
        System.out.println("ilk sayfanin handle degeri: "+driver.getWindowHandle());
        //window handle ederken ilk adim 1 sayfa acikken ilk sayfanin handle degerini alip bir stringe atamak.
        String ilkSayfaninHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        //burada 2. window acildi
        //2. window acildiginda birden fazla hanle ye sahip olduk.
        //2. sayfa acildiginda her iki sayfanin handle degerlerini koymak icin bir set olusturup getWindowHandels ile bu degerleri elde ettik.
        Set<String> tumWindowHandleleri=driver.getWindowHandles();
        System.out.println("Tum Handleler: "+tumWindowHandleleri);
        //3. adim set icerisinde birince sayfanin handele degerine esit olmayan handle degerini bulup bir string degiskene atamak.
        String ikinciWindowHandle="";
        for (String w:tumWindowHandleleri
             ) {
            if (!w.equals(ilkSayfaninHandle)){
                ikinciWindowHandle=w;
            }
        }
        //bu satira geldigimizde elimizde ikinci sayfanin handle si var.
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        System.out.println("ikinci sayfanin hashkodu: "+ikinciWindowHandle);
        driver.switchTo().window(ikinciWindowHandle);
        //switch to ile window degistirecek isk gidecegimiz windowun windowhandle degerine ihtiyac var
        String actualYeniTitle=driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"yeni sayfanin title i yanlis");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaninYazisi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actualSayfaYeniYazisi=yeniSayfaninYazisi.getText();
        softAssert.assertEquals(actualSayfaYeniYazisi,expectedYaziYeniSayfa,"beklendigi gibi degil");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
driver.switchTo().window(ilkSayfaninHandle);
        softAssert.assertEquals(actualTitle,expectedTitle,"title istenen degerden farkli");
        softAssert.assertAll();
    }
}
