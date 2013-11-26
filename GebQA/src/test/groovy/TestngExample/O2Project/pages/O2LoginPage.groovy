package TestngExample.O2Project.pages

import geb.Page
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/11/13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
class O2LoginPage extends Page {
    static url = "signin"
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

        allForgottenUsernameAndPasswordBoth {$("p", class : "arrowRight").find("a")}

        forgotUsernameLink {allForgottenUsernameAndPasswordBoth[1]}
        forgotPasswordLink {allForgottenUsernameAndPasswordBoth[2]}
        forgotBothLink {allForgottenUsernameAndPasswordBoth[3]}
        signIn (to: MyAccountsPage ) {submit ->$("input",type: submit, value: "Sign in")}

    }

    void function_signIn(String usernameValue, String passwordValue){
        username.value usernameValue
        password.value passwordValue
        signIn("submit").click()
    }
}

