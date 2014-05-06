package steps

import Helper.WebDriverHelper
import cucumber.api.DataTable
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import groovy.transform.Field
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
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
    driver.switchTo().alert()
    println driver.getTitle()
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
    robot.keyRelease(KeyEvent.VK_ENTER);
}

Then(~'I should be able reset the password'){->
    driver.findElement(By.cssSelector("#email")).sendKeys("password")
    driver.findElement(By.cssSelector("#form_submit")).click()
    assert driver.findElement(By.cssSelector("#content")).getText() == "Your e-mail's been sent!"
}

Then(~'I should be to login in the page'){->
    driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith")
    driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!")
    driver.findElement(By.cssSelector(".radius")).click()
    driver.findElement(By.cssSelector(".button.secondary.radius")).click()
}

Then(~'I should be able to switch the frame'){->
    assert driver.switchTo().frame("frame-top").switchTo().frame("frame-left").findElement(By.cssSelector("body")).text == "LEFT"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-top").switchTo().frame(1).findElement(By.cssSelector("body")).text == "MIDDLE"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-top").switchTo().frame(2).findElement(By.cssSelector("body")).text == "RIGHT"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-bottom").findElement(By.cssSelector("body")).text == "BOTTOM"
    driver.switchTo().defaultContent();
}

Then(~'I should be able to look at google page'){->
    driver.findElement(By.cssSelector("button[onclick='getLocation()']")).click()
    Thread.sleep(5000)
    driver.findElement(By.cssSelector("#map-link>a")).click()
    Thread.sleep(5000)
    WebElement element = driver.findElement(By.xpath("//*[@id='mtgt_A.1000']"))
    new Actions(driver).doubleClick(element).perform()
}

Then(~'I should be able to work with jquery'){->
    WebElement element = driver.findElement(By.xpath("//*[@id='ui-id-2']"))
    element.click()
    driver.findElement(By.xpath("//*[@id='ui-id-4']"))

//    ((JavascriptExecutor) driver).executeScript("document.getElementById('ui-id-2').style.display='block';");
//    new Select(driver.findElement(By.xpath("//*@id='ctl00_ContentPlaceHolder1_ddlOnbehalfOf']"))).selectByIndex(2);
}

Then(~'I should be able to validate javascript'){->
    JavascriptExecutor js = (JavascriptExecutor)driver
    js.executeScript("jsAlert();")
    driver.switchTo().alert().accept()
    driver.switchTo().defaultContent()
    assert driver.findElement(By.cssSelector("#result")).text == "You successfuly clicked an alert"

    js.executeScript("jsConfirm();")
    Alert alert = driver.switchTo().alert()
    assert alert.getText() == "I am a JS Confirm"
    alert.accept()
    driver.switchTo().defaultContent()
    assert driver.findElement(By.cssSelector("#result")).text == "You clicked: Ok"

    driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]")).click()
    alert = driver.switchTo().alert()
    alert.sendKeys("test confirm")
    alert.accept()
    assert driver.findElement(By.cssSelector("#result")).text == "You entered: test confirm"

}

Then(~'I should be able to handle multiple windows'){->
    String parentWindow = driver.getWindowHandle()
    driver.findElement(By.cssSelector(".example >a")).click()

    for(String window: driver.getWindowHandles()){
        driver.switchTo().window(window)
    }
    driver.close()
    driver.switchTo().window(parentWindow)
}

Then(~'I should see the notification message'){->
    driver.findElement(By.cssSelector(".example>p>a")).click()
    println driver.findElement(By.cssSelector("#flash")).text
    assert driver.findElement(By.cssSelector("#flash")).text.contains("Action")

}
After("@end"){
    driver.close()
}