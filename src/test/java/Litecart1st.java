import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.ContextList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Litecart1st {
    WebDriver drv;

    @Before
    public void chrome_setup(){
        WebDriverManager.chromedriver().setup();
        drv = new ChromeDriver();
    }

    @After
    public void chrome_cleanup(){
    drv.quit();
    }

    @Test
    public void chromeTest(){
        drv.get("http://localhost/litecart/public_html/admin/login.php");
        drv.findElement(By.name("username")).sendKeys("admin");
        drv.findElement(By.name("password")).sendKeys("admin");
        drv.findElement(By.name("login")).click();
//        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println("Elements # is " + drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]")).size());

        int links = drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]")).size();
        for (int i = 0; i < links; i++) {
            List<WebElement> elementList = drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
            WebElement menuItem = elementList.get(i);
            menuItem.click();
            if ( drv.findElement(By.cssSelector("#content > h1")) != null){
                System.out.println("Menu Item #" + i + " OK");
            }

            int subLinks = drv.findElements(By.cssSelector("[id^=\"doc-\"]")).size();
            System.out.println("SubMenuList # is " + subLinks);

            for (int x = 0; x < subLinks; x++) {
                List<WebElement> subMenuList = drv.findElements(By.cssSelector("[id^=\"doc-\"]"));
                WebElement subMenuItem = subMenuList.get(x);
                subMenuItem.click();
                if ( drv.findElement(By.cssSelector("#content > h1")) != null){
                    System.out.println("Sub Menu Item #" + x + " OK");
                }

        }

    }
}
}
