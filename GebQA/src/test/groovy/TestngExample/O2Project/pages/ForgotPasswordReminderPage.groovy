package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/11/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class ForgotPasswordReminderPage extends O2BasePage {
    static url = "http://www.o2.co.uk/registrationpasswordreminder"
    static at = {
        url.equals("http://www.o2.co.uk/registrationpasswordreminder")
    }
}
