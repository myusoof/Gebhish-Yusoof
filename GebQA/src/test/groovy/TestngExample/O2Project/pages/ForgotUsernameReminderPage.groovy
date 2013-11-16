package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/11/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class ForgotUsernameReminderPage extends Page {
    static url = "http://www.o2.co.uk/registrationusernamereminder"
    static at = {
        url.equals("http://www.o2.co.uk/registrationusernamereminder")
    }
    static content = {
    }
}
