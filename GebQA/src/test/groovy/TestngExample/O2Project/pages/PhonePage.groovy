package TestngExample.O2Project.pages

import TestngExample.O2Project.module.BaseModule
import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 08/12/13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
class PhonePage extends O2BasePage{

    static at = {
        title == "O2 | Upgrade | Phones"
    }

    static content = {
        activeTab {$(".activeTab a")}
        activeTab_1 {alaises: activeTab}
        selectTab {tabText -> $("#tabsDefault li").filter(".activeTab").find(text: tabText)}
        selectPhoneWithModel1 {modelName -> module BaseModule, modelName : modelName}
        //selectPhoneWithModel {modelName ->$("a").has(class : "model", text: modelName)}

    }
}
