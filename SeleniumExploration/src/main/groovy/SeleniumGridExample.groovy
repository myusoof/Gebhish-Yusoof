import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class SeleniumGridExample {
    WebDriver driver = null
    @BeforeTest
    void setup(){
        driver = WebDriverInitialization.initializeDriver(WebDriverInitialization.DriverType.firefox, new URL("http://localhost:5000/wd/hub"))
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

    @AfterTest
    void tearDown(){
        driver.quit()
    }
}
