package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 01/12/13
 * Time: 00:32
 * To change this template use File | Settings | File Templates.
 */
class SimplicityPage extends Page{

    static url = "store/simplicity/"

    static at = {
        title == "O2 | Simplicity tariffs"
    }


    static content =  {

        //simo tariff or plan tariff
        activePlanTab {$("#tabsDefault").find(".activeTab")}

        selectPlanTypeOf {tabText -> $("#tabsDefault ul li").find(text: "${tabText}")}
        //either 3G or 4G tab is selected
        coverageTab {coverageName ->$("#coverage li").not(".active").find("a", text: coverageName)}
        getNthElementSelected {nth ->$("#tariffTable tbody tr:nth-child(${nth})")}

        addbuttonOnNthPlan {n -> getNthElementSelected(n).find("td:nth-child(7) .buy-tariff-form")}


        getMonthlyCostInNthLine {n -> getNthElementSelected(n).find("td:nth-child(1)")}
        getTariffLengthInNthLine {n -> getNthElementSelected(n).find("td:nth-child(2)")}
        getTariffMinutesInNthLine {n -> getNthElementSelected(n).find("td:nth-child(3)")}
        getTariffTextsInNthLine {n -> getNthElementSelected(n).find("td:nth-child(4)")}
        getTariffDataInNthLine {n -> getNthElementSelected(n).find("td:nth-child(5)")}
        getTariffExtrasInNthLine {n -> getNthElementSelected(n).find("td:nth-child(6)")}
    }

}
