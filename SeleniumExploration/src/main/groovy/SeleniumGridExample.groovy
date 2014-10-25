import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class SeleniumGridExample {
    WebDriver driver = null
    @BeforeMethod
    void setup(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox()
        driver = new RemoteWebDriver(new URL("http://172.31.209.241:4444/wd/hub"), capabilities)
        }


    @Test()
    void firstSeleniumGrid17(){
        driver.get("http://the-internet.herokuapp.com/")
    }

    @Test
    void firstSeleniumGrid16(){
        driver.get("http://the-internet.herokuapp.com/")

    }
    @Test
    void firstSeleniumGrid15(){
        driver.get("http://the-internet.herokuapp.com/")
    }
    @Test
    void firstSeleniumGrid14(){
        driver.get("http://the-internet.herokuapp.com/")
    }
    @Test
    void firstSeleniumGrid13(){
        driver.get("http://the-internet.herokuapp.com/")
    }
    @Test
    void firstSeleniumGrid12(){
        driver.get("http://the-internet.herokuapp.com/")
    }
    @Test
    void firstSeleniumGrid11(){
        driver.get("http://the-internet.herokuapp.com/")
    }
}
