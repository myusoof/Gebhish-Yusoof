import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import java.rmi.Remote

class SeleniumGridExample {
    WebDriver driver = null
    @Before
    void setup(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox()
        driver = new RemoteWebDriver(new URL("http://172.31.209.241:4444/wd/hub"), capabilities)
        }


    @Test
    void firstSeleniumGrid(){
        driver.get("http://the-internet.herokuapp.com/")
    }

}
