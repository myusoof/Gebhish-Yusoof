package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 21:56
 * To change this template use File | Settings | File Templates.
 */
class CheckoutDeliveryOptionsPage extends WebDriverUtils implements Page{

        OrderReviewPage clickContinueonDeliveryPage(){

        driver.findElement(By.id("submit")).click()
        return new OrderReviewPage()
    }





}
