package TestngExample.GebhishProj

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/11/13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
class GoogleHomePage extends Page {

    // pages can define their location, either absolutely or relative to a base
    static url = "http://google.com/ncr"

    // “at checkers” allow verifying that the browser is at the expected page
    static at = { title == "Google" }

    static content = {
        // include the previously defined module
        search { module GoogleSearchModule, buttonValue: "Google Search" }
    }
}

class GoogleResultsPage extends Page {
    static at = { title.endsWith "Google Search" }
    static content = {
        // reuse our previously defined module
        search { module GoogleSearchModule, buttonValue: "Search" }

        // content definitions can compose and build from other definitions
        results { $("li.g") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("a.l") }
        firstResultLink { resultLink(0) }
    }
}

class WikipediaPage extends Page {
    static at = { title == "Wikipedia" }
}