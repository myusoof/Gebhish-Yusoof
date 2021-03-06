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
class CCAAgreementPage extends WebDriverUtils implements Page{

    CCAAgreementPage acceptKeyInformation(){
//        driver.findElement(By.cssSelector("a#keyInformationLink")).click()
        sleep(5000)
        driver.findElement(By.cssSelector("h2 a")).click()
        driver.findElement(By.id("goToSecci")).click()
        return new CCAAgreementPage()

    }
    void acceptSecci(){
        driver.findElement(By.id("secciTick")).click()
        driver.findElement(By.id("goToPayMonthlyTerms")).click()

    }
    void acceptPayMonthlyTerms(){
        driver.findElement(By.id("pmTermsTick")).click()
        driver.findElement(By.cssSelector("input[value='Accept and proceed to CCA']")).click()
    }

    void acceptPhonePlanCCA(){
        driver.findElement(By.id("declaration1")).click()
        driver.findElement(By.id("declaration2")).click()
        driver.findElement(By.id("declaration3")).click()
        driver.findElement(By.id("ccaSig")).click()
    }

    CheckoutDeliveryOptionsPage proceedToDelivery(){

        driver.findElement(By.id("ccaProceedToDeliveryOptions")).click()
        new CheckoutDeliveryOptionsPage()
    }





}
