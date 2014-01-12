import TestngExample.O2Project.pages.OopsPage
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 25/12/13
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */

//driver = {new org.openqa.selenium.chrome.ChromeDriver()}

//driver = 'firefox'
//driver = 'htmlunit'
//driver = 'org.openqa.selenium.chrome.ChromeDriver'
//driver = {new RemoteWebDriver(DesiredCapabilities.firefox())}

System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver")
System.setProperty("geb.env", "firefox")

driver = 'org.openqa.selenium.chrome.ChromeDriver'
//System.setProperty("geb.env", 'firefox')
//driver = 'chrome'
cacheDriver = false
cacheDriverPerThread = true
//atCheckWaiting = true
quitCachedDriverOnShutdown = false
baseUrl =  "http://localhost:8080/upgrade/"
reportsDir = "target/geb-reports"

unexpectedPages = [OopsPage]
reportOnTestFailureOnly = true
/*waiting {
    presets {
        slow {
            timeout = 10
            retryInterval = 0.5
        }
        quick {
            timeout = 1
        }
    }
}*/
waiting {
    timeout = 10
    retryInterval = 0.5
}

environments {
    // when system property 'geb.env' is set to 'win-ie' use a remote IE driver
    'firefox' {
        driver = {
              new FirefoxDriver()
//            new RemoteWebDriver( new URL("http://localhost:8080/upgrade/"),DesiredCapabilities.firefox())
        }
    }
    'chrome' {
        driver = {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver")
            new RemoteWebDriver( DesiredCapabilities.chrome())
        }
    }
}