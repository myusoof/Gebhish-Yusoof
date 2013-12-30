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
//driver = 'org.openqa.selenium.chrome.ChromeDriver'
driver = 'chrome'
