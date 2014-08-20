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
class CheckoutLoginPage extends WebDriverUtils implements Page{

        VerifyUserNamePage loginCustomer(String uname, String pwd) {
            driver.findElement(By.name("USERNAME")).sendKeys(uname);
            driver.findElement(By.name("PASSWORD")).sendKeys(pwd);
            driver.findElement(By.cssSelector("input[value='Continue']")).click();
            return new VerifyUserNamePage()
        }
}
