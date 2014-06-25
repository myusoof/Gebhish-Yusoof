package steps

import Helper.FileDownloader
import Helper.MailVerifier
import Helper.UrlStatusChecker
import Helper.WebDriverHelper
import cucumber.api.DataTable
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import groovy.transform.Field
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.interactions.Keyboard
import org.openqa.selenium.interactions.Mouse
import org.openqa.selenium.interactions.internal.Coordinates
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.security.Credentials
import org.openqa.selenium.security.UserAndPassword
import org.openqa.selenium.support.events.internal.EventFiringKeyboard
import org.openqa.selenium.support.events.internal.EventFiringMouse
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.awt.event.InputEvent
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
    driver.get(WebDriverHelper.baseUrl)
}

Given(~'I click on (.*) link'){ text->
    driver.findElement(By.xpath("//a[contains(., '${text}')]")).click()

}

Then(~'I should see the (.*) page'){pageUrl->
    assert driver.getCurrentUrl().contains(pageUrl)
}

Then(~'I validate whether user able to see the authenticated page'){->
    assert driver.findElement(By.xpath("//div/p")).getText() == "Congratulations! You must have the proper credentials."
}


Then(~'I verify the checkboxes in the page'){->
    def checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(1)"))
    if(!checkbox.isSelected()){
        checkbox.click()
    }
    println driver.findElement(By.cssSelector("form input:nth-of-type(2)")).isSelected()
}

Given(~'I navigate to the internet application with (.*) and password (.*)'){ username, password ->
    driver.navigate().to(driver.currentUrl.replace("http://","http://${username}:${password}@"))
}

Then(~'^I drag A and drop into B box$'){->
    Actions actions = new Actions(driver)
    driver.manage().window().maximize();
    WebElement source = driver.findElement(By.cssSelector(".column#column-a > header"))
    WebElement target = driver.findElement(By.cssSelector(".column#column-b > header"))
    actions.clickAndHold(source).build().perform()
    Thread.sleep(4000)

    moveMouseToElementPosition(target)
    Thread.sleep(4000)
    actions.release().build().perform()
}

def moveMouseToElementPosition(WebElement element){
    Locatable locatable = (Locatable)element
    def getXPositionOfLocatable = locatable.coordinates.onPage().x
    def getYPositionOfLocatable = locatable.coordinates.onPage().y

    println "get element postion"
    println "${getXPositionOfLocatable},${getYPositionOfLocatable}"
    def getLeftPositionOfWindow = driver.manage().window().getPosition().x
    def getTopPositionOfWindow = driver.manage().window().getPosition().y
    def xPosition = getLeftPositionOfWindow+getXPositionOfLocatable
    def yPosition = getYPositionOfLocatable+getTopPositionOfWindow
    Robot robot = new Robot()

    println "${xPosition}, ${yPosition}"
    robot.mouseMove(xPosition,yPosition+80 )

    Thread.sleep(2000)
    robot.mousePress(InputEvent.BUTTON1_MASK)
    robot.mouseRelease(InputEvent.BUTTON1_MASK)
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

Then(~'I should be able to upload the file'){->

    WebElement upload = driver.findElement(By.xpath("//*[@id='file-upload']"))
    upload.sendKeys("/home/ee/Desktop/379742_1882113871705_1600339459_n.jpg")
    driver.findElement(By.xpath("//*[@id='file-submit']")).click()
    assert driver.getPageSource().contains("File Uploaded!")
}
Then(~'I should be able to download a file (.*)'){ elementName ->
    WebElement element = elementToVerify(elementName)
    String elementHref = element.getAttribute("href")
    UrlStatusChecker urlStatusChecker = new UrlStatusChecker(driver)
    urlStatusChecker.setURIToCheck(elementHref)
    assert urlStatusChecker.getHttpStatusCode() == HttpURLConnection.HTTP_OK
    FileDownloader fileDownloader = new FileDownloader(driver)
    fileDownloader.localDownloadPath("/home/yusoof/")
    if(elementHref.endsWith("jpg")){
        println fileDownloader.downloadImage(element)
    } else{
        println fileDownloader.downloadFile(element)
    }


}

WebElement elementToVerify(String elementName){
    driver.findElement(By.xpath("//a[contains(.,'${elementName}')]"))
}

Then(~'I should be able reset the password'){->
    driver.findElement(By.cssSelector("#email")).sendKeys("yusooftesting@gmail.com")
    driver.findElement(By.cssSelector("#form_submit")).click()
    MailVerifier mailVerifier = new MailVerifier("imap.gmail.com","yusooftesting@gmail.com","Yusoof@1234")
    Thread.sleep(10000)
    assert mailVerifier.isMailFound()
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
//    ((JavascriptExecutor) driver).executeScript("document.getElementById(\"ui-id-5\").style.visibility='visible'")

//    ((JavascriptExecutor)driver).executeScript("var element = document.getElementById(\"ui-id-5\"); element.click();")
//    ((JavascriptExecutor) driver).executeScript("document.getElementById('ui-id-2').style.display='block';");
//    new Select(driver.findElement(By.xpath("//*@id='ctl00_ContentPlaceHolder1_ddlOnbehalfOf']"))).selectByIndex(2);

    Actions actions = new Actions(driver)
    actions.moveToElement(driver.findElement(By.cssSelector("#ui-id-2"))).perform()
//    waitForElement("#ui-id-5")
    driver.findElement(By.cssSelector("#ui-id-4")).click()
    driver.findElement(By.cssSelector("#ui-id-6")).click()
    actions.moveToElement(driver.findElement(By.cssSelector("#ui-id-4")))
//    waitForElement("#ui-id-6")

}
/*
private waitForElement(String cssPath){
    (new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
        Boolean apply(WebDriver input) {
            return input.findElement(By.cssSelector(cssPath)).isDisplayed()
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }))
}*/
Then(~'I should be able to validate javascript'){->
    JavascriptExecutor js = (JavascriptExecutor)driver
    js.executeScript("jsAlert();")
    Alert alert = driver.switchTo().alert()
    assert alert.getText() == "I am a JS Alert"
    alert.accept()
    driver.switchTo().defaultContent()
    assert driver.findElement(By.cssSelector("#result")).text == "You successfuly clicked an alert"

    js.executeScript("jsConfirm();")
    alert = driver.switchTo().alert()
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
