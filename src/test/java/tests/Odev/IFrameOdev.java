package tests.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class IFrameOdev extends TestBase {
    /*
    - Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-
project.html) tıklayınız
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> iFrameSayisi=driver.findElements(By.tagName("iframe"));
        System.out.println(iFrameSayisi.size());
        WebElement ilkYoutube=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(ilkYoutube);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.navigate().refresh();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(3000);
driver.switchTo().defaultContent();
    }

}
