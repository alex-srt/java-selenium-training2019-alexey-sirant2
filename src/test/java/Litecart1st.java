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
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> elementList = drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
        System.out.println("Elements # is " + elementList.size());
        List<String> elementsToArray = new ArrayList<>();
        for (int i=0; i<elementList.size(); i++){
            elementsToArray.add(elementList.get(i).getText());
            System.out.println(elementsToArray.get(i));
        }

        int links = drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]")).size();
        for (int i = 0; i < links; i++) {
            List<WebElement> elementListNew = drv.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
            WebElement menuItem = elementListNew.get(i);
            menuItem.click();
            if ( drv.findElement(By.cssSelector("#content > h1")) != null){
                System.out.println("OK");
            }
        }

    }


}
