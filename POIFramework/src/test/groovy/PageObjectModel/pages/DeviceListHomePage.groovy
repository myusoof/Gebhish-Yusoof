package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
class DeviceListHomePage extends WebDriverUtils implements Page{

    void clickOnTab(tabName){
        driver.findElement(By.cssSelector("#${tabName}Tab")).click()
    }

    void addItemToBasket(String id){
        sleep(5000)
        driver.findElement(By.cssSelector("#buy-${id}")).click()
    }

    void addDataAllowanceItemToBasket(String id){
        driver.findElement(By.cssSelector("#${id}")).click()
    }

    void addDataAllowanceToBasket(type, String id,String dataAllowanceProductId,standardOrCCA){
        if(type != "simo"){
            //driver.findElementByXPath(".//*[@id='${id}']/img").click()
        }else{
            if(dataAllowanceProductId.contains("Smartphone")){
                driver.findElement(By.xpath(".//*[@id='dataAllowancesTabContent']/ul/li[1]/label")).click()
               // driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }else if(dataAllowanceProductId.contains("iPhone")){
                driver.findElement(By.cssSelector("#iPhone")).click()
               // driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }else if(dataAllowanceProductId.concat("BlackBerry")){
                driver.findElement(By.cssSelector("#Blackberry")).click()
               // driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }
        }

    }


    void createPrivateBasket(){
        driver.findElement(By.cssSelector(".addPackage>img")).click()
    }

    DeliveryDetailsPage clickOnCheckOutButton(){
        sleep(5000)
        driver.findElement(By.cssSelector("#startCheckoutFromPrivateBasketButton")).click()
        return new DeliveryDetailsPage()
    }

    RegistrationPage startCheckout(){
        sleep(5000)
        driver.findElement(By.cssSelector("#startCheckoutFromPrivateBasketButton")).click()
        return new RegistrationPage()
    }

    void selectCcaPriceCombinationInBasketForNonFullCCA(){
        new Select(driver.findElement(By.xpath("//select"))).selectByIndex(1);
    }

    void selectCcaPriceCombinationInBasketForFullCCA(){
        //new Select(driver.findElement(By.xpath("//select"))).selectByIndex(3);
//        new Select(driver.findElement(By.xpath("//select"))).selectByIndex(2);
        sleep(4000)
        driver.findElement(By.cssSelector("option[value*='\"monthlyString\":\"£0.00\"']")).click()
    }
}

