package TestngExample.O2Project.pages

import TestngExample.O2Project.module.GoogleSearchModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 06/11/13
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
class GoogleHomePage extends O2BasePage {

    // pages can define their location, either absolutely or relative to a base
    static url = "http://google.com/ncr"

    // “at checkers” allow verifying that the browser is at the expected page
    static at = { title == "Google" }

    static content = {
        // include the previously defined module
        search { module GoogleSearchModule, buttonValue: "Google Search" }
        searchButton {$("#gbqfb")}
    }
}