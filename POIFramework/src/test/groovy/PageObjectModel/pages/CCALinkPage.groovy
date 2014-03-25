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
class CCALinkPage extends WebDriverUtils implements Page{

    String getGeneratedCCALink(){
        driver.findElement(By.cssSelector("span#ccaId a")).getText()
    }
}
