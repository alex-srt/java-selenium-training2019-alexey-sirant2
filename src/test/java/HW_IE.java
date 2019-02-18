import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HW_IE {

    WebDriver drv;


    @Before
    public void ieTest_setup(){
        WebDriverManager.iedriver().setup();
        drv = new InternetExplorerDriver();
    }

    @After
    public void googleTest_cleanup(){

        drv.quit();
    }

    @Test
    public void ieTest(){
        drv.get("https://www.seleniumhq.org");

    }

}
