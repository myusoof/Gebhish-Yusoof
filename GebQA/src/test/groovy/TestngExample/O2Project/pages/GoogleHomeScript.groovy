package TestngExample.O2Project.pages

import TestngExample.O2Project.modules.GoogleSearchModule
import geb.Browser
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/11/13
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */

class GoogleHomeScript {
    @Test
    void TestMethodOne(){
        Browser.drive {
            to GoogleHomePage
            assert at(GoogleHomePage)
            search.field.value("wikipedia")
            waitFor { at GoogleResultPage }
            assert firstResultLink.text() == "Wikipedia"
            firstResultLink.click()
            waitFor { at WikipediaPage}
            close()
        }
    }
}
