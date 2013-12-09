package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 08/12/13
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
class PhonePage extends Page{

    static at = {
        title == "O2 | Upgrade | Phones"
    }

    static content = {
        activeTab {$(".activeTab a")}
        selectTab {tabText -> $("#tabsDefault li").filter(".activeTab").find(text: tabText)}
        selectPhoneWithModel {modelName ->$("a").has(class : "model", text: modelName)}
    }

    class BrandAndModelName{
        String brand
        String model

        String convertToPath(){

        }
    }
}
