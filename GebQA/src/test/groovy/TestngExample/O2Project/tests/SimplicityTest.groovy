package TestngExample.O2Project.tests

import TestngExample.O2Project.Steps.O2BaseSteps
import TestngExample.O2Project.pages.SimplicityPage
import org.openqa.selenium.Keys
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 01/12/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
class SimplicityTest extends O2BaseSteps {

    @Test
    void basicSimplicityTest(){
        browserWrapper.browser.with {
            to SimplicityPage
            at SimplicityPage
            selectPlanTypeOf("Phone tariffs").click()
            selectPlanTypeOf("Sim only tariffs").click()
            assert getMonthlyCostInNthLine("3").text() == "£13.50"
            assert getTariffLengthInNthLine("3").text() == "30 Days"
            assert getTariffMinutesInNthLine("3").text() == "100\nminutes"
            assert getTariffTextsInNthLine("3").text() == "500\ntexts"
            assert getTariffDataInNthLine("3").text() == "100MB\ndata"
            assert getTariffExtrasInNthLine("3").text() == ""
            coverageTab ("4G").click()

            assert driver.getCurrentUrl()== "http://localhost:8080/upgrade/store/simplicity/SmartPhone/?is4G=true"
            quit()
        }
    }
}
