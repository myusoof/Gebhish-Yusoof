package TestngExample.O2Project.tests

import TestngExample.O2Project.Steps.O2BaseSteps
import TestngExample.O2Project.pages.ForgotPasswordReminderPage
import TestngExample.O2Project.pages.ForgotUsernamePasswordReminderPage
import TestngExample.O2Project.pages.ForgotUsernameReminderPage
import TestngExample.O2Project.pages.MyAccountsPage
import TestngExample.O2Project.pages.O2LoginPage
import TestngExample.O2Project.pages.YourOptionsPage
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
    void testToTestLinksInO2LoginPage(){
        browserWrapper.browser.to O2LoginPage
        browserWrapper.browser.at(O2LoginPage)
        browserWrapper.browser.forgotUsernameLink.click()
/*        browserWrapper.browser.withWindow(
                {browserWrapper.browser.driver.getCurrentUrl() ==
                        "http://www.o2.co.uk/registrationusernamereminder"}, close: true){
            println browserWrapper.browser.driver.title
        }*/
        HashSet<String> allOpenedWindows = browserWrapper.browser.getAvailableWindows()
        switchToWindow(allOpenedWindows[1])
        browserWrapper.browser.at ForgotUsernameReminderPage
        //browserWrapper.browser.to ForgotUsernameReminderPage
        browserWrapper.browser.driver.close()
        browserWrapper.browser.switchToWindow(allOpenedWindows[0])
        //switchToWindow(allOpenedWindows[0])

        browserWrapper.browser.at O2LoginPage
        browserWrapper.browser.forgotPasswordLink.click()

        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[1])

        browserWrapper.browser.at ForgotPasswordReminderPage
        browserWrapper.browser.removePageChangeListener(browserWrapper.listener)
        browserWrapper.browser.driver.close()
        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[0])
        browserWrapper.browser.at O2LoginPage

        browserWrapper.browser.forgotBothLink.click()

        allOpenedWindows = getAllCurrentWindows()
        switchToWindow(allOpenedWindows[1])

        browserWrapper.browser.at ForgotUsernamePasswordReminderPage
        browserWrapper.browser.driver.close()
        switchToWindow(allOpenedWindows[0])
        browserWrapper.browser.at O2LoginPage

        /*browserWrapper.browser.username.value("ID-002003")
        browserWrapper.browser.password.value("password")

        browserWrapper.browser.signIn("submit").click(MyAccountsPage)*/

        browserWrapper.browser.function_signIn "ID-002003", "password"
        browserWrapper.browser.at MyAccountsPage
        browserWrapper.browser.difId.text()
        browserWrapper.browser.welcomeText.text() == "Hi Mike Howes"
        assert ["07007002003", "07997992003"] ==  browserWrapper.browser.mobileNumberField
        //println browserWrapper.browser.driver.findElement(By.xpath("//*[@id=\"accountWrapper\"]/form[1]/div/div/div[3]/input")).getAttribute("value")
        browserWrapper.browser.page.upgradePhone("447007002003").click(YourOptionsPage)
        browserWrapper.browser.page.at YourOptionsPage
        //browserWrapper.browser.$("#accountWrapper").has("form", action : ~/.*447007002003.*/).find(type: "submit").click()
        assert browserWrapper.browser.page.$(".staticPage").text() == "Your Options"
        browserWrapper.browser.letsGoHandsetUpgradeButton.click()
        browserWrapper.browser.removePageChangeListener(browserWrapper.listener)
        browserWrapper.browser.quit()
    }
}
