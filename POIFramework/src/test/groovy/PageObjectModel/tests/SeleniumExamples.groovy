package PageObjectModel.tests

import com.gargoylesoftware.htmlunit.BrowserVersion
import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.testng.annotations.Test

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/04/14
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
class SeleniumExamples {
    @Test
    public void testOneSelenium(){
        WebDriver driver = new FirefoxDriver()
//        WebDriver driver = new HtmlUnitDriver(BrowserVersion.getDefault())
        println BrowserVersion.getDefault()
        driver.get("http://google.co.uk")
        driver.findElement(By.name("q")).sendKeys("Rukhsar")
        //File srcFile = driver.getScreenshotAs(OutputType.FILE)
        //FileUtils.moveFile(srcFile, new File("./${new Date()}.png"))
        driver.kill()
        driver.quit()
    }
}
