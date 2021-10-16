package tests.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Odev_Alert extends TestBase {
    @Test
    public void test() throws InterruptedException {
    //go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

    //click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(3000);

        // accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        Thread.sleep(3000);

    // cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
       Thread.sleep(3000);

    // click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
    driver.findElement(By.xpath("(//button[@onclick='promptbox()'])")).click();
    Thread.sleep(3000);

    // and then sendKeys 'TechProEducation' (Please enter your name)

        driver.switchTo().alert().sendKeys("Tugba");
       driver.switchTo().alert().accept();
        Thread.sleep(3000);

    // finally print on console this mesaaje "Hello TechproEducation How are you today"
        WebElement mesajiYazdir=driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(mesajiYazdir.getText());
    }
}