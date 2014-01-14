package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 31/12/13
 * Time: 00:18
 * To change this template use File | Settings | File Templates.
 */
class OopsPage extends Page{
    static at = {$(".error h2" ).text() == "We're sorry but we couldn't find the page you're looking for"}
}
