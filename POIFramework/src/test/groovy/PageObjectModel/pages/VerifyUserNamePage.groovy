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
class VerifyUserNamePage extends WebDriverUtils implements Page{

    CCAAgreementPage clickOnContinueButton(){
        driver.findElement(By.id("continue")).click()
        new CCAAgreementPage()
    }





}
