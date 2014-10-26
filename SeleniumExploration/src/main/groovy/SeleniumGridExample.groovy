import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class SeleniumGridExample {
    WebDriver driver = null
    @BeforeSuite
    void startServer(){
        Thread thread1 = new Thread(new SeleniumServerNodeStart("5000", "hub"), "selenium server start")
        Thread thread2 = new Thread(new SeleniumServerNodeStart("5555", "node"), "selenium node start")
        Thread thread3 = new Thread(new SeleniumServerNodeStart("5556", "node"), "selenium node start")
        [thread1, thread2, thread3].each {
            it.start()
        }
        driver = WebDriverInitialization.initializeDriver(WebDriverInitialization.DriverType.chrome, new URL("http://localhost:5000/wd/hub"))
    }
    @BeforeClass
    void setup(){

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
