package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/11/13
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
class WikipediaPage extends Page{
    static at = {title.startsWith("Wikipedia")}
}
