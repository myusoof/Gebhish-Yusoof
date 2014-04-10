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
class VisaProtectionPage extends WebDriverUtils implements Page{
    public void enter3DSecurePIN(){
        driver.findElement(By.name("external.field.password")).sendKeys("1234")
    }

    public OrderConfirmationPage clickOnSubmit(){
            driver.findElement(By.name("UsernamePasswordEntry")).click()
        sleep(10000)
            return new OrderConfirmationPage()
     }
}
