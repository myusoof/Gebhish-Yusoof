package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
class AccountSelectionPage extends WebDriverUtils implements Page{

    Page clickOnUpgradeButtonForMsisdn(msisdn){
        List<WebElement> upgradeElements = driver.findElements(By.cssSelector(".upgradeLink a"))
        for(WebElement element : upgradeElements){
            if(element.getAttribute("href").contains(msisdn)){
                element.click()
                break
            }
        }
        if(driver.getPageSource().contains("upgradeOpt eligibleOpt")){
            new UpgradeOptionsPage()

        }else{
            new DeviceListHomePage()
        }
    }
}
