package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MauseActions extends TestBase {
    @Test
    public void test(){
        //Yeni bir class olusturalim: D14_MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualdropyazisi=droppedYazisi.getText();
        String expecteddropYazisi="Dropped!";
        Assert.assertEquals(actualdropyazisi,expecteddropYazisi,"dropped yazisi beklenenden farkli");
    }
}
