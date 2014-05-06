package Helper

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/05/14
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
class WebDriverHelper {
    private static WebDriver webdriver = null

    private WebDriverHelper(){

    }

    public static WebDriver getInstance(){
        if(webdriver == null){
            Runtime.getRuntime().exec("/home/ee/Downloads/tools/autoit.exe")
            File profileDir = new File("/home/ee/5927wd2c.default");
            FirefoxProfile profile = new FirefoxProfile(profileDir);
            webdriver = new FirefoxDriver(profile);
            //webdriver = new FirefoxDriver()
        }
        webdriver
    }

    public static closeDriver(){
       webdriver.close()
       webdriver = null
    }

}
