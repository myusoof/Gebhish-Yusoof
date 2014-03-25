package PageObjectModel.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

import java.util.concurrent.TimeUnit
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
class WebDriverUtils {

    static WebDriver driver = new FirefoxDriver()

    static void webBrowserStart(baseUrl, msisdn){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("${baseUrl}/search?msisdn=${msisdn}&portalId=&fun=&PartnerId=o2&submit=Search")
    }

    static void webBrowserStartAcquisition(baseUrl){
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("${baseUrl}")
    }
}
