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

    public static WebDriver getInstance(WebDriverType type){

        switch (type){
            case WebDriverType.FIREFOX:
                if(webdriver == null){
                    Runtime.getRuntime().exec("/home/yusoof/autoitex.exe")
                    File profileDir = new File("/home/yusoof/axpnszte.default-1394997862883");
                    FirefoxProfile profile = new FirefoxProfile(profileDir);
                    webdriver = new FirefoxDriver(profile);
                    //webdriver = new FirefoxDriver()
                }
                return webdriver
                break
            case WebDriverType.HTML:
                if(webdriver == null){
                    webdriver = new HtmlUnitDriver()
                }
                return webdriver
                break
            default:
                return null
        }
        webdriver
    }

    public static closeDriver(){
       webdriver.close()
       webdriver = null
    }

}
