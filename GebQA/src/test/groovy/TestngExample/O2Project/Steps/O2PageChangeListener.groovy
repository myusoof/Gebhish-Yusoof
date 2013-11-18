package TestngExample.O2Project.Steps

import geb.Browser
import geb.Page
import geb.PageChangeListener

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 17/11/13
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
class O2PageChangeListener implements PageChangeListener {
    @Override
    void pageWillChange(Browser browser, Page oldPage, Page newPage) {
    println "This page change from ${oldPage} to ${newPage}"
    }
}
