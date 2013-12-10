package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/11/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class ForgotUsernamePasswordReminderPage extends O2BasePage {
    static at = {
        (driver.getCurrentUrl() == "http://www.o2.co.uk/registrationusernameandpasswordreminder"
        ||
        driver.getCurrentUrl() == "https://accounts.o2.co.uk/forgottendetails/retrieveusername"
        )
    }
}
