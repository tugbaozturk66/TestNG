package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //abstract yaparak bu classtan obje olusturmanin onune geciyoruz
    protected WebDriver driver;
    //biz test base classi sadece extends ile inherit ederek kullanacagiz
    //dolayisiyle olusturdugumuz driver variabla icin protected access modifieri seciyoruz.
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
