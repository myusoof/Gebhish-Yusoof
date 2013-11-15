package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/11/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
class O2LoginPage extends Page {
    static url = "http://localhost:8080/upgrade/"
    static at = {
        title == "O2 | Upgrade | O2 | Upgrade | Sign In"
    }
    static content = {
        username {$("input", 0, name:"USERNAME", id:"user_name" )}
        password {$("input",0, name:"PASSWORD", id: "user_password")}
        signIn (to: MyAccountsPage ) {$("input",type: "submit", value: "Sign in")}

    }
}
