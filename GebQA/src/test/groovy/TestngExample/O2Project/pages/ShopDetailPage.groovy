package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 12/12/13
 * Time: 00:06
 * To change this template use File | Settings | File Templates.
 */
class ShopDetailPage extends Page{
    static url = "store/"
    static at = {title.endsWith("Buy now on Pay Monthly")}

    def shopDetailUrl = new ShopDetailUrl(model: "apple", "iphone-5-64gb-purple-cca")
    String convertToPath(){
    }
}

class ShopDetailUrl {
    String model
    String brand

}