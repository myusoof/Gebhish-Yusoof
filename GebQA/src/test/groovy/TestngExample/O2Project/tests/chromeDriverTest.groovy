package TestngExample.O2Project.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 30/12/13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
class chromeDriverTest {
    @Test
    void testMethod() {
        //System.setProperty("webdriver.chrome.driver", "/home/ee/Downloads/personal/chromedriver")

        System.setProperty("webdriver.chrome.driver", "GebQA/src/test/resources/chromedriver")

        //DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        WebDriver driver = new ChromeDriver()
        driver.get("http://google.co.uk/")
        driver.close()
    }
}
