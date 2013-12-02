package TestngExample.O2Project.Steps

import TestngExample.O2Project.pages.O2LoginPage
import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/11/13
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
class O2BaseSteps {

    Browser browser
    BrowserWrapper browserWrapper = new BrowserWrapper(browser)


    String getCurrentWindows(){
        browserWrapper.browser.driver.getWindowHandle()
    }

    HashSet<String> getAllCurrentWindows(){
        browserWrapper.browser.driver.getWindowHandles()
    }
    void switchToWindow(String windowId){
        browserWrapper.browser.driver.switchTo().window(windowId)

    }
}
