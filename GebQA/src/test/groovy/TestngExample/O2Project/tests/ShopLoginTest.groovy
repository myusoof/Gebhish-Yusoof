package TestngExample.O2Project.tests

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
class ShopLoginTest {

    @Test
    void shopLogin(){
        Browser.drive {
            to O2LoginPage
            assert welcome.text() == "Welcome to O2 Upgrades"
            //assert at(O2LoginPage).title == "O2 | Upgrade | O2 | Upgrade | Sign In"
            username.value("ID-002003")
            password.value("password")
            signIn.click()
            at MyAccountsPage
            welcomeText.text() == "Hi Mike Howes"
            assert ["07007002003", "07997992003"] ==  mobileNumberField
        }
    }
}
