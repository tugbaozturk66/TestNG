package tests.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElifHocaOdev extends TestBase {
    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    //click on second emoji
    //click all second emoji's element
    //go back parent iframe
    //fill out the form,(Fill the form with the texts you want)
    //click on apply button
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='emoojis']")));
    driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
    Thread.sleep(3000);
        List<WebElement> allEmojis=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        for (WebElement each:allEmojis)
        {
            each.click();
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("bear");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("dunya");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("doga");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("tatli");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("yuruyus");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("deniz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("qa");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("saat");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("yuzuk");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("hide");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='active']")).sendKeys("active");
        Thread.sleep(2000);

        /*List<WebElement>form =driver.findElements(By.xpath("//div[@data-upgraded=',MaterialTextfield']/input"));
        List<String>eklenecekler= new ArrayList<>(Arrays.asList("muzik","gezme","bear","gul","Turkey","gitmek","tabs","yozgat","66","azra","yusuf"));
        for (int i = 0;i<form.size(); i++) {
            form.get(i).sendKeys(eklenecekler.get(i));

        }*/
        driver.findElement(By.xpath("(//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-button--colored'])[1]")).click();
    }
}
