package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
class PaymentPage extends WebDriverUtils implements Page{
    public void enterSecurityNumber(){

        waitForElement(By.id("txtCardSecurityCode"))
        driver.findElement(By.id("txtCardSecurityCode")).sendKeys("123")
    }

    public void enterSecureNumberforVisa(){
           driver.findElement(By.id("txtCardSecurityCode")).sendKeys("123")
    }

//    public VisaProtectionPage clickOnPayNow(){
//        driver.findElement(By.id("btnPayNow")).click();
//        sleep(7000)
//        return new VisaProtectionPage();
//    }

    public OrderConfirmationPage clickOnPayNow(){
        driver.findElement(By.id("btnPayNow")).click();
        sleep(7000)
        return new OrderConfirmationPage();
    }
}
