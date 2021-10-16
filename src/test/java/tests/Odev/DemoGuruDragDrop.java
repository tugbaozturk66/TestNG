package tests.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DemoGuruDragDrop extends TestBase {

    @Test
    public  void test() throws InterruptedException {

        // //1) Go to http://demo.guru99.com/test/drag_drop.html url
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //    //    Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankButton=driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement actionSectionDebitSide=driver.findElement(By.xpath("(//li[@class='placeholder'])"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(bankButton,actionSectionDebitSide).perform();
        Thread.sleep(5000);
        //    //    Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesButton=driver.findElement(By.xpath("//li[@class='block15 ui-draggable']"));
        WebElement actionSectionCreditSide=driver.findElement(By.xpath("//ol[@class='field15 ui-droppable ui-sortable']"));
        actions.dragAndDrop(salesButton,actionSectionCreditSide).perform();
        Thread.sleep(5000);

        //    //    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement debit5000=driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])"));
        WebElement amountSectionDebitSide=driver.findElement(By.xpath("(//ol[@id='amt7'])"));
        actions.dragAndDrop(debit5000,amountSectionDebitSide).perform();
        Thread.sleep(5000);
        //    //    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement sales5000=driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[2]"));
        WebElement amountSectionCreditSide=driver.findElement(By.xpath("//ol[@id='amt8']"));
        actions.dragAndDrop(sales5000,amountSectionCreditSide).perform();
    Thread.sleep(5000);
    }
}
