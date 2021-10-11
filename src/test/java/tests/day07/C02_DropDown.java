package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    //Bir class oluşturun: DropDown
//https://the-internet.herokuapp.com/dropdown adresine gidin.
     //       1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
  // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
  //  4.Tüm dropdown değerleri(value) yazdırın
   // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void amazonTest() throws InterruptedException {
        //index kullanarak
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select select= new Select(dropDown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //2.Value kullanarak
        Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4
        List <WebElement> tumOpsiyonlar=select.getOptions();
        System.out.println("tumopsiyonlar listesi");
        for (WebElement each:tumOpsiyonlar){
            System.out.println(each.getText());
        }
        System.out.println(tumOpsiyonlar.size());
        if (tumOpsiyonlar.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
