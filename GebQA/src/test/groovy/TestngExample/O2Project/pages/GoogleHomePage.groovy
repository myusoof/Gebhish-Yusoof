package TestngExample.O2Project.pages

import TestngExample.O2Project.modules.GoogleSearchModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/11/13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
class GoogleHomePage extends Page{
    static url = "http://google.com/ncr"

    static at = {title == "Google"}
    static content = {
        search {module GoogleSearchModule, buttonValue : "Google Search"}
    }
}