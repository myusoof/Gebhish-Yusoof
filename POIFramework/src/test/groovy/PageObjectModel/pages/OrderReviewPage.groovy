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
class OrderReviewPage extends WebDriverUtils implements Page{
    public void clickOnConfirmO2TermsAndConditions(){
        driver.findElement(By.id("terms")).click();
    }


    public PaymentPage clickOnPayNow(){
        driver.findElement(By.cssSelector("input[value='Pay now']")).click();
        return new PaymentPage();
    }
}
