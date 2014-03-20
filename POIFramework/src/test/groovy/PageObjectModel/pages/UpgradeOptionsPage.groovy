package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
class UpgradeOptionsPage extends WebDriverUtils implements Page{

    DeviceListHomePage clickOnUpgradeForFreeButton(handsetCCAOrSimo){
        driver.findElement(By.cssSelector("#${handsetCCAOrSimo}.upgradeOpt.eligibleOpt>div a")).click()
        new DeviceListHomePage()
    }
}
