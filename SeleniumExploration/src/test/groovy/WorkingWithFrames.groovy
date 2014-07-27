import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

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
