package TestngExample.O2Project.module

import geb.Module

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 16/12/13
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
class BaseModule extends Module{

    def modelName
    static content = {
        selectPhoneWithModel {$("a").has(class : "model", text: modelName)}
    }
}
