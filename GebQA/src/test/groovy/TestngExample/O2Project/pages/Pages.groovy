package TestngExample.O2Project.pages

import TestngExample.O2Project.modules.GoogleSearchModule

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 05/11/13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
import geb.Browser
import geb.Page
import geb.Module

// modules are reusable fragments that can be used across pages that can be paramaterised
// here we are using a module to model the search function on the home and results pages

class GoogleSearchModule extends Module{
    def buttonvalue


    static content = {
        field { $("input", name: "q") }

        button(to: GoogleResultPage) {
            $("input", value : buttonvalue)
        }
    }
}

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

