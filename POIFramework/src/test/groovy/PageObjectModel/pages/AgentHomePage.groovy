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
class AgentHomePage extends WebDriverUtils implements Page{

    DeviceListHomePage clickOnNewCustomerNewConnection(){
        driver.findElement(By.cssSelector("#acquisition >p a")).click()
        new DeviceListHomePage()
    }
}
