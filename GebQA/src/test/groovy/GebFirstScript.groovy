import geb.Browser

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 02/11/13
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 */
Browser.drive {
    go("http://localhost:8080/upgrade/signIn/")
    assert  title == "O2 | Upgrade | O2 | Upgrade | Sign In"
    close()
}
