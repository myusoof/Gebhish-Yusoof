package TestngExample

import geb.Browser
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 02/11/13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
class FirstTestngClass {
    @Test
    void testMethodOne(){
        Browser.drive {
            go("http://localhost:8080/upgrade/signIn/")
            assert  title == "O2 | Upgrade | O2 | Upgrade | Sign In"
            /*$("div").each {
                 println it.getAttribute("id")
            }*/
            println $("div", id : "header").getAttribute("id")
            println $("div" , id: "qa-login").find("div.signinContainer").parent()
            /*println $("div", 0).getAttribute("id")*/
            close()
        }
    }
}
