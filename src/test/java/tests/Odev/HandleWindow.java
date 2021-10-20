package tests.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class HandleWindow extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //      get the first window
        String firstWindowHandle= driver.getWindowHandle();

        //      clicking on click here button
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //      get all the window in the set
        Set<String> allWindowHandle= driver.getWindowHandles();
        String secondWindowHandle="";
        for (String w:allWindowHandle
             ) {
            if(!(w.equals(firstWindowHandle))){
               secondWindowHandle=w;
            }
        }
        //      switch to window
        driver.switchTo().window(secondWindowHandle);

        //      input email id (someone@gmail.com) and type something in that input
         driver.findElement(By.name("emailid")).sendKeys("someone@gmail.com"+ Keys.ENTER);

        //      Clicking on the submit button
        //driver.findElement(By.id("btnlogin")).click();
        //yukarida keys.ENTER ile submit yapilabildiginden bu asamayi yoruma aldim.

        //      verify title as expected
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getTitle().equals("Guru99 Bank Home Page"));
        softAssert.assertAll();

        //      switch to first window
        driver.switchTo().window(firstWindowHandle);

    }

}
