package TestngExample.O2Project.Tests

import TestngExample.O2Project.pages.GoogleHomePage
import TestngExample.O2Project.pages.GoogleResultsPage

import geb.Browser

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 05/11/13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
class FirstTest {

    public static void main(String ...args){
    Browser.drive {
        to GoogleHomePage
        assert at(GoogleHomePage)
        search.field.value("wikipedia")
        waitFor { at GoogleResultsPage }
        assert firstResultLink.text() == "Wikipedia"
        firstResultLink.click()
        waitFor { at WikipediaPage }
        close()
    }
    }
}
