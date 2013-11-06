package TestngExample.O2Project.Tests

import TestngExample.O2Project.pages.GoogleHomePage
import TestngExample.O2Project.pages.GoogleResultsPage
import TestngExample.O2Project.pages.WikipediaPage
import geb.Browser
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 05/11/13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
class FirstTest {
    @Test
    void theFirstTest(){
        Browser.drive {
            to GoogleHomePage
            assert at(GoogleHomePage)
            search.field.value("wikipedia")
            waitFor { at GoogleResultsPage }
            assert firstResultLink.text() == "Wikipedia"
            firstResultLink.click()
            waitFor { at WikipediaPage }
        }
    }
}
