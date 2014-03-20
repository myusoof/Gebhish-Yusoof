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
class DeviceListHomePage extends WebDriverUtils implements Page{

    void clickOnTab(tabName){
        sleep(2000)
        driver.findElement(By.cssSelector("#${tabName}Tab")).click()
    }

    void addItemToBasket(String id){
        sleep(2000)
        driver.findElement(By.cssSelector("#buy-${id}")).click()
    }

    void addDataAllowanceToBasket(type, String id,String dataAllowanceProductId,standardOrCCA){
        sleep(2000)
        if(type != "simo"){
            driver.findElementByXPath(".//*[@id='${id}']/img").click()
        }else{
            if(dataAllowanceProductId.contains("Smartphone")){
                driver.findElement(By.xpath(".//*[@id='dataAllowancesTabContent']/ul/li[1]/label")).click()
                driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }else if(dataAllowanceProductId.contains("iPhone")){
                driver.findElement(By.cssSelector("#iPhone")).click()
                driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }else if(dataAllowanceProductId.concat("BlackBerry")){
                driver.findElement(By.cssSelector("#Blackberry")).click()
                driver.findElementByXPath(".//*[@id='${id}']/img").click()
            }
        }

    }

    void selectOneAndMonthlyCCAPrice(){

    }

    void createPrivateBasket(){
        sleep(6000)
        driver.findElement(By.cssSelector(".addPackage>img")).click()
    }

    DeliveryDetailsPage clickOnCheckOutButton(){
        sleep(5000)
        driver.findElement(By.cssSelector("#startCheckoutFromPrivateBasketButton")).click()
        return new DeliveryDetailsPage()
    }
}
