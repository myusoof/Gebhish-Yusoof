package TestngExample.GebhishProj

import geb.Module

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/11/13
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
class GoogleSearchModule extends Module{

    def buttonValue

    static content = {
        field {$("input", name : 'q')}

        button(to: GoogleHomePage){
            $('input', name : buttonValue)
        }
    }

}
