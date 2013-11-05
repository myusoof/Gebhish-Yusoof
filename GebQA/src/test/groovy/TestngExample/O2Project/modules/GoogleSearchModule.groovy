package TestngExample.O2Project.modules


import geb.Module

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/11/13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
class GoogleSearchModule extends Module{
    def buttonvalue


    static content = {
        field { $("input", name: "q") }

        button(to: GoogleResultPage) {
          $("input", value : buttonvalue)
        }
    }
}
