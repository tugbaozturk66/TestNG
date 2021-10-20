package tests.Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Odev191021 {
    protected WebDriver driver;
    @BeforeClass
 public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {

    // Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
    // click on Phones & PDAs
        driver.findElement(By.xpath("//a[text()='Phones & PDAs']")).click();
    // get the brandName of phones
        Thread.sleep(5000);
        List<String> allNames=new ArrayList<>();
        List<WebElement> brandNames=driver.findElements(By.tagName("h4"));
        for (WebElement w:brandNames
             ) {
           allNames.add(w.getText());
        }
        System.out.println(allNames);

    // click on add to button for all elements
        List<WebElement> addButton=driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        for (WebElement w:addButton) {
            w.click();
        }

    // click on black total added cart button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
        Thread.sleep(3000);

        // get the names of list from the cart
        List<String> displayList=new ArrayList<>();
        List<WebElement> namesOfList=driver.findElements(By.xpath("//td[@class='text-left']//a"));
        for (WebElement w:namesOfList) {
            displayList.add(w.getText());
        }
        System.out.println(displayList);
    // compare the names from displaying list and cart list
        Assert.assertEquals(allNames,displayList,"listeler esit degil");
        //System.out.println("sepet eklenen listesi"+cartList);
        System.out.println("sepet gorunen listesi"+displayList+"  "+displayList.size());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
