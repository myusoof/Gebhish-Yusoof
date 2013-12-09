package TestngExample.O2Project.pages

import TestngExample.O2Project.module.SignInOutModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 26/11/13
 * Time: 00:45
 * To change this template use File | Settings | File Templates.
 */
class YourOptionsPage extends Page{
    static at = {
        title == "O2 | Upgrade | Your upgrade options"
    }

    static content = {
        letsGoHandsetUpgradeButton {$(".btn-style.btn-secondary-dark").filter("a", href: ~/.*phone.*/)}
        //letsGoHandsetUpgradeButton {$(".btn-style btn-secondary-dark").has("a", href: ~/.*phone.*/)}

        signOutLink {module SignInOutModule}
    }
}
