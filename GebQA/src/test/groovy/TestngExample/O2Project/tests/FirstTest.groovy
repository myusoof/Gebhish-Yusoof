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
            waitFor(message : "test message") { at GoogleResultsPage }
            assert firstResultLink.text() == "Wikipedia"
            firstResultLink.click()
            waitFor { at WikipediaPage }
        }
    }

    @Test
    void theSecondTest(){
        Browser.drive {
            cleanReportGroupDir()
            to GoogleHomePage
            reportGroup("google")
            report("google home page")
            assert at(GoogleHomePage)
            search.field.value("selenium:pdf")
            searchButton.click()
            waitFor(message : "test message") { at GoogleResultsPage }
            def bytes = downloadBytes(pdfSecondLink.@href)
            println bytes
            close()

        }
    }

}
