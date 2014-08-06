import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 05/08/14
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
class SeleniumFirstTest {

   WebDriver driver = new FirefoxDriver()
    @Test
    void firstTest(){
        driver.navigate().to("https://www.o2.co.uk/shop/phones/")
        driver.navigate().to("http://google.co.uk")

        driver.manage().window()

        driver.close()
    }
}
