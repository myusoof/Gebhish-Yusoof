import com.gargoylesoftware.htmlunit.BrowserVersion
import org.openqa.selenium.Capabilities
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created by yusoof on 26/10/14.
 */
class WebDriverInitialization {

    static WebDriver driver
    static FirefoxProfile profile = new FirefoxProfile()
    static enum DriverType{
        chrome,
        firefox,
        html,
        iexplore,
        opera,
        safari,
        javascriptDisabledFF,
        firefoxIphone,
        firefoxIpad

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
            case DriverType.html:
                capabilities = DesiredCapabilities.htmlUnit()
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(false)
                driver = new RemoteWebDriver(hubUrl, capabilities)
//                driver = new HtmlUnitDriver(capabilities)
                break
            case DriverType.chrome:
                System.setProperty("webdriver.chrome.driver", WebDriverInitialization.class.getResource("/chromedriver").getPath());
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            case DriverType.iexplore:
                capabilities = DesiredCapabilities.internetExplorer()
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true)
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
                driver = new RemoteWebDriver(hubUrl, capabilities)
            case DriverType.opera:
                capabilities = DesiredCapabilities.opera()
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setJavascriptEnabled(true)
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            case DriverType.safari:
                capabilities = DesiredCapabilities.safari()
                capabilities.setJavascriptEnabled(true)
                capabilities.setCapability("platform", Platform.LINUX)
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            case DriverType.javascriptDisabledFF:
                profile.setAcceptUntrustedCertificates(true)
                profile.setAssumeUntrustedCertificateIssuer(true)
                profile.setPreference("javascript.enabled", true)
                capabilities = DesiredCapabilities.firefox()
                capabilities.setCapability(FirefoxDriver.PROFILE, profile)
                driver = new RemoteWebDriver(hubUrl,capabilities)
                break
            case DriverType.firefoxIphone:
                profile.setAssumeUntrustedCertificateIssuer(true)
                profile.setAcceptUntrustedCertificates(true)
                profile.setPreference("javascript.enabled", true)
                profile.setPreference("general.useragent.overrider", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16")
                capabilities = DesiredCapabilities.firefox()
                capabilities.setCapability(FirefoxDriver.PROFILE, profile)
                capabilities.setCapability("platform", Platform.LINUX)
                driver = new RemoteWebDriver(hubUrl, capabilities)
                break
            case DriverType.firefoxIpad:
                profile.setAssumeUntrustedCertificateIssuer(true)
                profile.setAcceptUntrustedCertificates(true)
                profile.setPreference("javascript.enabled", true)
                profile.setPreference("general.useragent.overrider", "Mozilla/5.0(iPad; U; CPU OS 4_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8F191 Safari/6533.18.5")
                capabilities = DesiredCapabilities.firefox()
                capabilities.setCapability(FirefoxDriver.PROFILE, profile)
                capabilities.setCapability("platform", Platform.LINUX)
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
