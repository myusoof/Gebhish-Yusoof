package TestngExample.O2Project.pages

import TestngExample.O2Project.module.SignInOutModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 10/12/13
 * Time: 00:40
 * To change this template use File | Settings | File Templates.
 */
class O2BasePage extends Page{

    static content = {
        signOutLink {module SignInOutModule}
    }
}
