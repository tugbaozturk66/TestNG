package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Odev {
    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void test1(){
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
        WebElement dropdown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> fiyatListesi=driver.findElements(By.className("inventory_item_price"));
        List<String> fiyatListesiString=new ArrayList<>();
        for (WebElement w:fiyatListesi
             ) {
            fiyatListesiString.add(w.getText().replace("$",""));

        }
        List<Double> fiyatListesiDouble=new ArrayList<>();
        for (String w:fiyatListesiString
             ) {
            fiyatListesiDouble.add(Double.parseDouble(w));

        }
        System.out.println(fiyatListesiDouble);
    }
    @AfterClass
    public void tearDown(){

    }
}
