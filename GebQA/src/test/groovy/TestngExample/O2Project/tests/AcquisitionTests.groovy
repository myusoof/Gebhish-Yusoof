package TestngExample.O2Project.tests

import TestngExample.O2Project.Steps.BrowserWrapper
import TestngExample.O2Project.Steps.O2BaseSteps
import TestngExample.O2Project.pages.AcquisitionShopHomePage
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/12/13
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
class AcquisitionTests extends  O2BaseSteps{

    @BeforeTest
    void beforeTest(){
        browserWrapper = new BrowserWrapper(browser)
    }

    @Test
    void BasicAcquisitionTest(){
     browserWrapper.browser.with {
         to AcquisitionShopHomePage

         quit()
     }
    }
}
