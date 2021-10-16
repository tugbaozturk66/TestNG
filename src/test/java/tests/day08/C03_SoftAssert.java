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
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {
    //Yeni bir Class Olusturun : D10_SoftAssertTest
 //1. “http://zero.webappsecurity.com/” Adresine gidin
 // 2. Sign in butonuna basin
 // 3. Login kutusuna “username” yazin
 // 4. Password kutusuna “password.” yazin
 // 5. Sign in tusuna basin
 // 6. Pay Bills sayfasina gidin
 // 7. “Purchase Foreign Currency” tusuna basin
 // 8. “Currency” drop down menusunden Eurozone’u secin
 // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    WebDriver driver;
 @BeforeClass
 public void setup(){

  WebDriverManager.chromedriver().setup();
  driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  driver.get("http://zero.webappsecurity.com/");

 }
 @Test
 public void test1(){
  driver.findElement(By.xpath("//button[@id='signin_button']")).click();
  driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
  driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
  driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
driver.navigate().back();
driver.findElement(By.xpath("//a[@class='btn btn-small btn-info']")).click();
driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
WebElement dropdown =driver.findElement(By.xpath("//select[@id='pc_currency']"));
  Select select=new Select(dropdown);
  select.selectByVisibleText("Eurozone (euro)");
        String actualData=select.getFirstSelectedOption().getText();
String expectedData="Eurozone (euro)";
  SoftAssert softAssert=new SoftAssert();
  softAssert.assertEquals(actualData,expectedData,"secilen eurozone degil");
  List <WebElement> tumOpsiyonlar=select.getOptions();
  //opsiyonlar web elementlerden olusuyor
  //expected liste ise String bunun icin listeyi string yapmaliyiz
  List<String> tumOpsiyonlarString=new ArrayList<>();
  for (WebElement each:tumOpsiyonlar
       ) {tumOpsiyonlarString.add(each.getText());

  }
  List<String> expectedOptionsList= Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
 softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"liste ayni degil");
 softAssert.assertAll();
 }
 @AfterClass
 public void tearDown(){
  driver.close();
 }
}
