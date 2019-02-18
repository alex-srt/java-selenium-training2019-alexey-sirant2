import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW_FF {

    WebDriver drv;


    @Before
    public void ffTest_setup(){
        WebDriverManager.firefoxdriver().setup();
        drv = new FirefoxDriver();
    }

    @After
    public void googleTest_cleanup(){

        drv.quit();
    }

    @Test
    public void ffTest(){
        drv.get("https://www.seleniumhq.org");

    }
//
}
