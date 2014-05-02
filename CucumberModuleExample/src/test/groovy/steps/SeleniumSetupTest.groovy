package steps

import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

import java.util.concurrent.TimeUnit

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 02/05/14
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
class SeleniumSetupTest {

    @Test
    void testMethodOne(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    void testMethodTwo(){
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
//        driver.get("http://www.google.com");
//
//
//        ChromeOptions options = new ChromeOptions();
//// set some options
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        dc.setCapability(ChromeOptions.CAPABILITY, options);
//        WebDriver driver1 = new RemoteWebDriver(dc)

        println new File("./CucumberModuleExample").getCanonicalPath()

        System.setProperty("webdriver.chrome.driver", "${new File("./CucumberModuleExample").getCanonicalPath()}/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.uk")
        driver.quit()

    }
}
