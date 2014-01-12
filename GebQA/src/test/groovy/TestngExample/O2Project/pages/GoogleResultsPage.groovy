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
class GoogleResultsPage extends O2BasePage {
    static at = { title.endsWith "Google Search" }
    static content = {
        // reuse our previously defined module
        search { module GoogleSearchModule, buttonValue: "Search" }
        // content definitions can compose and build from other definitions
        results { $("li.g") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("a.l") }
        firstResultLink { resultLink(0) }
        pdfSecondLink {$("li:nth-child(2) a")}
    }
}