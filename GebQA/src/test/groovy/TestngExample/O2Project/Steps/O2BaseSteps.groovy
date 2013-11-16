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
    Browser browser = new Browser(driver: new FirefoxDriver(), baseUrl: "http://localhost:8080/" )

    String getCurrentWindows(){
        browser.driver.getWindowHandle()
    }

    HashSet<String> getAllCurrentWindows(){
        browser.driver.getWindowHandles()
    }
    void switchToWindow(String windowId){
        browser.driver.switchTo().window(windowId)

    }
}
