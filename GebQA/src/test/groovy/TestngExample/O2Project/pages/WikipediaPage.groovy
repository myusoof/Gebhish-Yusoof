package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 06/11/13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
class WikipediaPage extends O2BasePage {
    static at = { title.startsWith("Wikipedia") }
}