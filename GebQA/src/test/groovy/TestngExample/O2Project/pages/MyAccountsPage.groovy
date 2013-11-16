package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/11/13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
class MyAccountsPage extends Page {

    static at = { title == "O2 | Upgrade | My accounts"}
    static content ={
        welcomeText {$("div", id: "contentFull").find('h2')}

        mobileNumberField {$("span.detailValue").collect{ it.text()}}
    }

}
