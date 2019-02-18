import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Chrome {

    WebDriver drv;


    @Before
    public void chromeTest_setup(){
        WebDriverManager.chromedriver().setup();
        drv = new ChromeDriver();
    }

    @After
    public void googleTest_cleanup(){

        drv.quit();
    }

    @Test
    public void chromeTest(){
        drv.get("https://www.seleniumhq.org");

    }
//
}
