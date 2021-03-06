import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/07/14
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithFrames {

    @Test
    void WorkingWithFrames1(){
        WebDriver driver = new FirefoxDriver()
        driver.navigate().to("http://the-internet.herokuapp.com")

        new WebDriverWait(driver, 10).until(new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(By.className(""))
                return new ArrayList<WebElement>().add(element)
            }})
        driver.findElement(By.xpath("//a[contains(.,'Frames')]")).click()
        driver.findElement(By.xpath("//a[contains(.,'Nested Frames')]")).click()

        driver.switchTo().frame("frame-top").switchTo().frame("frame-left")
        println driver.findElement(By.xpath("//body")).text

        driver.switchTo().defaultContent()

        driver.navigate().back()

        driver.findElement(By.xpath("//a[contains(.,'iFrame')]")).click()

        driver.switchTo().frame("mce_0_ifr")

        println driver.findElement(By.xpath("//body/p")).text

        driver.close()

    }
}
