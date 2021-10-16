package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ActionClassHomeWork extends TestBase {
@Test
    public void test() throws InterruptedException {
    // Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");
    //2- Hover over Me First" kutusunun ustune gelin
    WebElement hoverOverMeFirst=driver.findElement(By.xpath("//div[@class='dropdown hover']"));
    Actions actions=new Actions(driver);
    actions.moveToElement(hoverOverMeFirst).perform();
    Thread.sleep(3000);
    //3- Link 1" e tiklayin
    driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
    Thread.sleep(3000);
    //4- Popup mesajini yazdirin
    System.out.println(driver.switchTo().alert().getText());
    //5- Popup'i tamam diyerek kapatin
    driver.switchTo().alert().accept();
    //6- “Click and hold" kutusuna basili tutun
    WebElement clickAndHold=driver.findElement(By.xpath("//div[@id='click-box']"));
    actions.clickAndHold(clickAndHold).perform();
    // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
    System.out.println(clickAndHold.getText());
    //8- “Double click me" butonunu cift tiklayin
    WebElement doubleClickMe=driver.findElement(By.xpath("//div[@id='double-click']"));
    actions.doubleClick(doubleClickMe).perform();
    Thread.sleep(3000);


}
}
