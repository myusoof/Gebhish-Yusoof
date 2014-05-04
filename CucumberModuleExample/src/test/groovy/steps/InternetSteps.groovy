package steps

import Helper.WebDriverHelper
import cucumber.api.DataTable
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import groovy.transform.Field
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait

import java.awt.Robot
import java.awt.event.KeyEvent

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/05/14
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

 @Field
 WebDriver driver = WebDriverHelper.getInstance()


Given(~'^I navigate to the internet application$'){->
    driver.get("http://the-internet.herokuapp.com/")
}

Given(~'I click on (.*) link'){ text->
    driver.findElement(By.xpath("//a[contains(., '${text}')]")).click()
}

Then(~'I should see the (.*) page'){pageUrl->
    assert driver.getCurrentUrl().contains(pageUrl)
}

Then(~'I enter the username and password in the authentication page'){->
    println driver.getWindowHandles().size()
}

Then(~'I verify the checkboxes in the page'){->
    def checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(1)"))
    if(!checkbox.isSelected()){
        checkbox.click()
    }
    println driver.findElement(By.cssSelector("form input:nth-of-type(2)")).isSelected()
}

Then(~'^I drag A and drop into B box$'){->
    WebElement source = driver.findElement(By.cssSelector(".column#column-a"))
    WebElement target = driver.findElement(By.cssSelector(".column#column-b"))
    println target.getLocation()

    Actions builder = new Actions(driver)
    builder.clickAndHold(source).build().perform();
    int xoffset, yoffset = 0
    for(int i=0;i<200;i++) {
        builder.moveToElement(source,xoffset*i,yoffset).build().perform();//builder.moveToElement(destination,xoffset,yoffset*i).build().perform();
    }
    builder.release(target).build().perform();
}

Then(~'I should be able to select item in the dropdown'){->
    new Select(driver.findElement(By.cssSelector("#dropdown"))).selectByValue("1")
    new Select(driver.findElement(By.cssSelector("#dropdown"))).selectByValue("2")
}

Then(~'I click on element containing href'){DataTable table ->
    table.raw().each {
        driver.findElement(By.xpath("//a[contains(@href, \"${it.get(0)}\")]")).click()
        driver.findElement(By.cssSelector("#start button")).click()
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("#finish h4")).isDisplayed();
            }
        };
        new WebDriverWait(driver, 10).until(e)
        driver.navigate().back()
    }
}

Then(~'I should be able to download a file'){->
    driver.findElement(By.xpath("//a[contains(.,'avatar.jpg')]")).click()
    Robot robot = new Robot()
    robot.keyPress(KeyEvent.VK_ENTER)
}
After("@end"){
    driver.close()
}