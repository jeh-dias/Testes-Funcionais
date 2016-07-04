package inserir.viagem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Insere_linkedin {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost/controle-cead/logar.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testWebDriver1() throws Exception {
        Random random = new Random();
        driver.findElement(By.cssSelector("b")).click();
        Number no_of_frameworks = (Integer) driver.findElements(By.xpath("//ul[@class='chzn-results']/li[contains(@id,'selGDE_chzn')]")).size();
        int actual_random_size = (Integer) no_of_frameworks;
        int random_value = random.nextInt(actual_random_size);
        int actual_random_value = 0;
        if (random_value == 0 || random_value == 1) {
            actual_random_value = 2;
        } else if (random_value == actual_random_size) {
            actual_random_value = actual_random_size;
        }

       // driver.findElement(By.cssSelector("ul.chzn-results > li:nth-child(" + actual_random_value + ")").click();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

  /*  private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
       // } catch (NoSuchElementException e) {
            return false;
        }
    }*/
}
