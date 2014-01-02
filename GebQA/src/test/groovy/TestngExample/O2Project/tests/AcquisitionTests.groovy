package TestngExample.O2Project.tests

import TestngExample.O2Project.Steps.BrowserWrapper
import TestngExample.O2Project.Steps.O2BaseSteps
import TestngExample.O2Project.pages.AcquisitionShopHomePage
import TestngExample.O2Project.pages.ShopDetailPage
import TestngExample.O2Project.pages.ShopDetailUrl
import geb.Page
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
        def shopDetailUrl = new ShopDetailUrl(model: "apple",brand: "iphone-5-64gb-purple-cca")
        browserWrapper.browser.with {
            to AcquisitionShopHomePage
            at AcquisitionShopHomePage
            to ShopDetailPage, "apple", "iphone-5-64gb-purple-cca/"
            to ShopDetailPage, shopDetailUrl
            //to demonstrate unexpected page functionality
            println js.exec("return document.title")
            //to ShopDetailPage, "asfdfde"
            println config.driver
            println config.isCacheDriver()
            quit()
        }
    }
}
