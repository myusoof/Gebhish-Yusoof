import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.browserlaunchers.locators.FirefoxPathLocator
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Proxy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select

import java.util.concurrent.TimeUnit

/**
 * Created by yusoof on 21/10/14.
 */
class DesiredCapExample {
    public static void main(String[] args) {
/*//        FirefoxProfile profile = new FirefoxProfile()
//        profile.updateUserPrefs()
        String proxyUrl = "http://localhost:8080"
        Proxy proxy = new Proxy()
        proxy.setHttpProxy(proxyUrl).setFtpProxy(proxyUrl).setSslProxy(proxyUrl)

        DesiredCapabilities dc = DesiredCapabilities.firefox()
        dc.setCapability(CapabilityType.PROXY, proxy)
//        dc.setCapability(FirefoxDriver.PROFILE, profile)
*/
        ExpectedConditions
        ProfilesIni allProfiles = new ProfilesIni();
        println allProfiles.profiles.entrySet().each {
            println it.key + " " + it.value
        }
        FirefoxProfile profile = new FirefoxProfile(new File("/home/yusoof/.mozilla/firefox/b8w0eafh.WebDriver"))
        FirefoxDriver driver = new FirefoxDriver(profile)

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get("http://the-internet.herokuapp.com/")
        Boolean abc = (Boolean)((JavascriptExecutor)driver).executeScript("return true;")
        println abc

        List<WebElement> labels = driver.findElements(By.tagName("div"));
        println labels.size()
        for(WebElement label: labels){
            println label.getAttribute("id")
        }

        def list = [1,2,3,4]

        String a = (String)((JavascriptExecutor)driver).executeScript("var list = arguments[0]; return list[0]", list)
        println a

        List<WebElement> listElement = (List<WebElement>)((JavascriptExecutor)driver).executeScript("var labels = arguments[0], inputs = []; " +
                "for (var i =0; i < labels.length; i++){" +
                "inputs.push(document.getElementById('flash-messages'))" +
                " }" +
                "return inputs", labels)
        listElement.removeAll("")
        println listElement.size()
        driver.manage().getCookies()
        /*
        List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)driver).executeScript(
                "var labels = arguments[0], inputs = []; " +
                        "for (var i=0; i < labels.length; i++){" +
                        "inputs.push(document.getElementById(labels[i].getAttribute('id'))); };" +
                        " return inputs;", labels);
        inputs.each {
            println it.getAttribute("class")
        }*/
        driver.quit()

    }
}
