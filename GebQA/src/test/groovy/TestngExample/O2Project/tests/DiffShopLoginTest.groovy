package TestngExample.O2Project.tests

import TestngExample.O2Project.Steps.O2BaseSteps
import TestngExample.O2Project.pages.ForgotUsernamePasswordReminderPage
import TestngExample.O2Project.pages.ForgotUsernameReminderPage
import TestngExample.O2Project.pages.MyAccountsPage
import TestngExample.O2Project.pages.O2LoginPage
import geb.Browser
import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/11/13
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
class DiffShopLoginTest extends O2BaseSteps {

    @Test
    void shopLogin(){
        browser.to O2LoginPage
        String winHandleBefore = getCurrentWindows()
        //assert at(O2LoginPage).title == "O2 | Upgrade | O2 | Upgrade | Sign In"
        browser.forgotUsernameLink.click()

        HashSet<String> allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[1])
        //browser.to ForgotUsernameReminderPage
        browser.driver.close()
        switchToWindow(allOpenedWindows[0])
        browser.at O2LoginPage
        browser.forgotPasswordLink.click()

        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[1])

        browser.driver.close()
        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[0])
        browser.at O2LoginPage

        browser.forgotBothLink.click()
        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[1])
        browser.at ForgotUsernamePasswordReminderPage
        browser.driver.close()
        switchToWindow(allOpenedWindows[0])
        browser.at O2LoginPage

        browser.username.value("ID-002003")
        browser.password.value("password")

        browser.signIn.click()
        browser.at MyAccountsPage
        browser.welcomeText.text() == "Hi Mike Howes"
        assert ["07007002003", "07997992003"] ==  browser.mobileNumberField
        println browser.driver.findElement(By.xpath("//*[@id=\"accountWrapper\"]/form[1]/div/div/div[3]/input")).getAttribute("value")
        browser.quit()
    }
}
