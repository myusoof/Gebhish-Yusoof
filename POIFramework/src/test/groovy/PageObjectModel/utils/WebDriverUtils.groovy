package PageObjectModel.utils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

import java.util.concurrent.TimeUnit
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
class WebDriverUtils {

    static WebDriver driver


    static WebDriver setFirefoxProfile(){
        FirefoxProfile profile = new FirefoxProfile();
        /*System.setProperty("webdriver.firefox.profile","firefoxProfile");
        String browserProfile = System.getProperty("webdriver.firefox.profile");
        FirefoxProfile profile = allProfiles.getProfile(browserProfile);*/
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        driver = new FirefoxDriver(profile);
    }

    static void webBrowserStart(baseUrl, msisdn){
        driver = setFirefoxProfile()

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("${baseUrl}/search?msisdn=${msisdn}&portalId=&fun=&PartnerId=o2&submit=Search")
    }

    static void webBrowserStartAcquisition(baseUrl){
        driver = setFirefoxProfile()
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("${baseUrl}")
    }

    static void accessCCALinkToCheckout(url){
        driver = setFirefoxProfile();
        driver.get("${url}")
    }

    static String randomEmailGenerator(){
        Random rand = new Random()

        int max = 1000000000
        return "abc${rand.nextInt(max+1)}@gmail.com"
    }

}
