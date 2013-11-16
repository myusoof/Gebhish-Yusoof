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
    static url = "http://localhost:8080/upgrade/signin"
    static at = {
        title == "O2 | Upgrade | O2 | Upgrade | Sign In"
    }
    static content = {
        welcome {$("#qa-login").find("h1")}
        refreshText {$(".bannerPromo").find("p")}
        signInText {$(".bannerPromo").find("h2")}
        username {$("input", 0, name:"USERNAME", id:"user_name" )}
        password {$("input",0, name:"PASSWORD", id: "user_password")}
        registerButtom {$("#qa-registration")}

        forgottenUsernameAndPasswordBoth(to: ForgotUsernameReminderPage){$("p", class : "arrowRight").find("a")}

        forgotUsernameLink(at: ForgotUsernameReminderPage) {forgottenUsernameAndPasswordBoth[1]}
        forgotPasswordLink(at: ForgotPasswordReminderPage) {forgottenUsernameAndPasswordBoth[2]}
        forgotBothLink(at: ForgotUsernamePasswordReminderPage) {forgottenUsernameAndPasswordBoth[3]}
        signIn (to: MyAccountsPage ) {$("input",type: "submit", value: "Sign in")}
    }
}
