package TestngExample.O2Project.Steps

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 17/11/13
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
class BrowserWrapper {
    Browser browser = new Browser()
    def listener = new O2PageChangeListener()


    BrowserWrapper(Browser browser){
      browser = this.browser
      browser.registerPageChangeListener(listener)
    }
}
