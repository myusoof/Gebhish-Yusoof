import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created by yusoof on 26/10/14.
 */
class WebDriverInitialization {

    static WebDriver driver

    static enum DriverType{
        chrome,
        firefox,

    }
    static WebDriver initializeDriver(DriverType driverType, URL hubUrl){
        DesiredCapabilities capabilities = null;
        switch (driverType){
            case DriverType.firefox:
                capabilities = DesiredCapabilities.firefox()
                capabilities.setBrowserName("firefox")
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true)
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            case DriverType.chrome:
                System.setProperty("webdriver.chrome.driver", WebDriverInitialization.class.getResource("/chromedriver").getPath());
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            default:
                capabilities = DesiredCapabilities.firefox()
                capabilities.setBrowserName("firefox")
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true)
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
                driver = new RemoteWebDriver(hubUrl, capabilities)

            driver
        }

    }

}
