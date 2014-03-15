package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
class DeviceListHomePage extends WebDriverUtils{

    void clickOnTab(tabName){
        sleep(2000)
        driver.findElement(By.cssSelector("#${tabName}Tab")).click()
    }

    void addItemToBasket(String id){
        sleep(2000)
        driver.findElement(By.cssSelector("#buy-${id}")).click()
    }

    void addDataAllowanceToBasket(String id){
        sleep(2000)
        driver.findElementByXPath(".//*[@id='${id}']/img").click()
    }


    void createPrivateBasket(){
        driver.findElement(By.cssSelector(".addPackage>img")).click()
    }

    DeliveryDetailsPage clickOnCheckOutButton(){
        sleep(5000)
        driver.findElement(By.cssSelector("#startCheckoutFromPrivateBasketButton")).click()
        return new DeliveryDetailsPage()
    }
}
