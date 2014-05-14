package Helper

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.htmlunit.HtmlUnitDriver

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

    static enum WebDriverType{
        HTML,
        FIREFOX
    }

    public static WebDriver getInstance(){

                if(webdriver == null){
                    //FirefoxProfile profile = new FirefoxProfile(profileDir);
                    webdriver = new HtmlUnitDriver()
                    //webdriver = new FirefoxDriver()
                }
               webdriver
    }

    public static closeDriver(){
       webdriver.close()
       webdriver = null
    }

}
