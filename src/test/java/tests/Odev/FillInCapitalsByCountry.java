package tests.Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FillInCapitalsByCountry {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
         /*
    go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    Fill in capitals by country
     */
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions=new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("box1")),driver.findElement(By.id("box101"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box2")),driver.findElement(By.id("box102"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box3")),driver.findElement(By.id("box103"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box4")),driver.findElement(By.id("box104"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box5")),driver.findElement(By.id("box105"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box6")),driver.findElement(By.id("box106"))).perform();
        actions.dragAndDrop(driver.findElement(By.id("box7")),driver.findElement(By.id("box107"))).perform();
        Thread.sleep(3000);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
