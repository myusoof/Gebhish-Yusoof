package TestngExample.O2Project.module

import TestngExample.O2Project.pages.O2LoginPage
import geb.Module

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/12/13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
class SignInOutModule extends Module{

    static content = {

        signOutButton(to: O2LoginPage) {$(".signOut")}
    }
}
