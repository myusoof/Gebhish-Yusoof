package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
class OrderConfirmationPage extends WebDriverUtils implements Page{
    String verifyOrderSubmittedSuccessfully(){
        sleep(5000)
        assert driver.findElement(By.cssSelector(".sectionHeading")).getText() == "Order confirmed"
        return driver.findElement(By.cssSelector("#orderNumber")).getText()
    }

    String verifyOrderSubmittedThroughCheckout(){
            sleep(5000)
            assert driver.getPageSource().contains("Order Confirmation")
            return driver.findElement(By.cssSelector("p#orderNumber")).getText()
        }
 }

