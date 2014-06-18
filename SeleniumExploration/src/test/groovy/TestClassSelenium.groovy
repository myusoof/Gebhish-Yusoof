import com.gargoylesoftware.htmlunit.BrowserVersion
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/06/14
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
class TestClassSelenium {
    @Test
    void testOne(){
        WebDriver driver = new HtmlUnitDriver(DesiredCapabilities.firefox())
//        WebDriver driver = new HtmlUnitDriver(BrowserVersion.getDefault())
        println BrowserVersion.getDefault()
        println driver.determineBrowserVersion(DesiredCapabilities.firefox())
        println driver.getWindowHandle()
        driver.switchTo().window(driver.getWindowHandle())
        driver.get("http://google.co.uk")
        driver.manage().getCookies().toString().split(";")
        By.className()
        driver.findElement(By.name("q")).sendKeys("Rukhsar")
        //File srcFile = driver.getScreenshotAs(OutputType.FILE)
        //FileUtils.moveFile(srcFile, new File("./${new Date()}.png"))
        driver.quit()
    }

    @Test
    void testTwo(){
        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.firefox())
        driver.get("http://localhost:8350/#/login")
        driver.findElement(By.id("username")).sendKeys("sysadmin@productworks.com")
        driver.findElement(By.id("password")).sendKeys("Password")
    }
}
