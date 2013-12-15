package TestngExample.O2Project.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 12/12/13
 * Time: 00:06
 * To change this template use File | Settings | File Templates.
 */
class ShopDetailUrl {
    String model
    String brand

}

class ShopDetailPage extends Page{
    static url = "store/phones/"
    static at = { title.contains("Buy")}

    String convertToPath(ShopDetailUrl shopDetailUrl){
        shopDetailUrl.model + "/" + shopDetailUrl.brand + "/"
    }
}

