package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Odev2_DropDown {
    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol
    //edin.
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");

    }
    @Test
    public void test1() throws InterruptedException {
driver.findElement(By.xpath("//button[@id='signin_button']")).click();
driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.navigate().back();
driver.findElement(By.xpath("//a[@id='online-banking']")).click();
driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
driver.findElement(By.xpath ("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select =new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("1");
        WebElement usDollars= driver.findElement(By.xpath("(//label[@class='radio inline'])[2]"));
        Assert.assertFalse(usDollars.isSelected(),"us dollars secili");
        driver.findElement(By.xpath("(//label[@class='radio inline'])[3]")).click();
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Foreign currency cash was successfully purchased."),"metni icermiyor");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
