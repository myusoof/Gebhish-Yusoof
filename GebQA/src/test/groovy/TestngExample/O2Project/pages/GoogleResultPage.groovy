package TestngExample.O2Project.pages

import TestngExample.O2Project.modules.GoogleSearchModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/11/13
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
class GoogleResultPage extends Page{
    static at = {title.endsWith("Google Search")}
    static content ={
        search{module GoogleSearchModule, buttonValue: "Search"}

        firstResultLink{ $('li.g', 0).find('a.l')}
    }
}