package steps

import Helper.ConfigurationHelper
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
import org.openqa.selenium.Dimension
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

@Field
Robot robot = new Robot()


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

Then(~'^the table (.*) looks like$'){table, DataTable dataTable->
    WebElement tableContent = driver.findElement(By.xpath("//*[@id=\'${table}\']"))
    List<WebElement> rows = tableContent.findElements(By.xpath("//tr"))
    rows*.findElements(By.xpath("th,td")).collect {
    }
}

def moveMouseToElementPosition(WebElement element){
    Locatable locatable = (Locatable)element
    /*def getXPositionOfLocatable = locatable.coordinates.onPage().x
    def getYPositionOfLocatable = locatable.coordinates.onPage().y
    */
    def getXPositionOfLocatable = locatable.coordinates.inViewPort().x
    def getYPositionOfLocatable = locatable.coordinates.onPage().y

    println "get element postion"
    println "${getXPositionOfLocatable},${getYPositionOfLocatable}"
    def getLeftPositionOfWindow = driver.manage().window().getPosition().x
    def getTopPositionOfWindow = driver.manage().window().getPosition().y
    def xPosition = getLeftPositionOfWindow+getXPositionOfLocatable
    def yPosition = getYPositionOfLocatable+getTopPositionOfWindow

    println "${xPosition}, ${yPosition}"
    robot.mouseMove(xPosition,yPosition+80 )

    Thread.sleep(2000)
    robot.mousePress(InputEvent.BUTTON1_MASK)
    robot.mouseRelease(InputEvent.BUTTON1_MASK)
}

Then(~'I should be able to select item in the dropdown'){->
    Select select = new Select(driver.findElement(By.cssSelector("#dropdown")))
    select.selectByVisibleText("Option 1")
    select.selectByVisibleText("Option 2")
//    select.selectByValue("1")
//    select.selectByValue("2")

    println select.isMultiple()
    println select.getOptions().collect{it.text}
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
    println urlStatusChecker.localDownloadPath
    fileDownloader.localDownloadPath(urlStatusChecker.localDownloadPath)
    println fileDownloader.downloadImage(element)
    /*if(elementHref.endsWith("jpg")){
        println fileDownloader.downloadImage(element)
    } else{
        println fileDownloader.downloadFile(element)
    }*/
}

WebElement elementToVerify(String elementName){
    driver.findElement(By.xpath("//a[contains(.,'${elementName}')]"))
}

Then(~'I should be able reset the password'){->
    driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationHelper.getConfiguration().getProperty("emailAddress"))
    driver.findElement(By.cssSelector("#form_submit")).click()
    MailVerifier mailVerifier = new MailVerifier(ConfigurationHelper.getConfiguration().getProperty("mailServer"),ConfigurationHelper.getConfiguration().getProperty("emailAddress"),ConfigurationHelper.getConfiguration().getProperty("emailPassword"))
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
    driver.findElement(By.xpath("//a[contains(.,'Nested Frames')]")).click()
    assert driver.switchTo().frame("frame-top").switchTo().frame("frame-left").findElement(By.cssSelector("body")).text == "LEFT"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-top").switchTo().frame(1).findElement(By.cssSelector("body")).text == "MIDDLE"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-top").switchTo().frame(2).findElement(By.cssSelector("body")).text == "RIGHT"
    driver.switchTo().defaultContent();
    assert driver.switchTo().frame("frame-bottom").findElement(By.cssSelector("body")).text == "BOTTOM"
    driver.switchTo().defaultContent();
}

Then(~'I should be able to verify whether mouse hover'){->
    WebElement firstHover = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"))
    WebElement secondHover = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"))
    WebElement thirdHover = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"))
    Actions action = new Actions(driver)
    action.moveToElement(firstHover)
    action.build().perform()
    assert driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div")).getText() == "name: user1\nView profile"
    action.moveToElement(secondHover)
    action.build().perform()
    assert driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div")).getText() == "name: user2\nView profile"
    action.moveToElement(thirdHover)
    action.build().perform()
    assert driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div")).getText() == "name: user3\nView profile"

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

    Double test = ((JavascriptExecutor) driver).executeScript("\$('#ui-id-1').parent().css('opacity')")
    println test
    ((JavascriptExecutor) driver).executeScript("\$('#ui-id-2').parent().trigger('click')")

    Actions actions = new Actions(driver)
    assert !driver.findElement(By.cssSelector("#ui-id-1")).isEnabled()

    actions.moveToElement(driver.findElement(By.cssSelector("#ui-id-2"))).build().perform()
//    waitForElement("#ui-id-5")
    actions.moveToElement(driver.findElement(By.cssSelector("#ui-id-4"))).build().perform()
    assert driver.findElement(By.cssSelector("#ui-id-6")).isDisplayed()
}

private waitForElement(String cssPath){
    (new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
        Boolean apply(WebDriver input) {
            return input.findElement(By.cssSelector(cssPath)).isDisplayed()
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }))
}

    Then(~'I should be able to validate javascript'){->
    JavascriptExecutor js = (JavascriptExecutor)driver
    //js.executeScript("jsAlert();")

    driver.findElement(By.xpath("//button[1]")).click()

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

        Set<String> windowHandles = driver.getWindowHandles()
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

Then(~'I click on redirected page'){->
    driver.findElement(By.cssSelector("#redirect")).click()
    assert driver.currentUrl.contains("status_codes")
}

Then(~'I verify the status code'){->
    String urlToVerify = driver.findElement(By.xpath("//a[contains(., '200')]")).getAttribute("href")
    UrlStatusChecker urlStatusChecker = new UrlStatusChecker(driver)

    urlStatusChecker.setURIToCheck(urlToVerify)
    assert urlStatusChecker.getHttpStatusCode() == 200

    urlToVerify = driver.findElement(By.xpath("//a[contains(., '301')]")).getAttribute("href")
    urlStatusChecker.setURIToCheck(urlToVerify)
    assert urlStatusChecker.getHttpStatusCode() == 301

    urlToVerify = driver.findElement(By.xpath("//a[contains(., '404')]")).getAttribute("href")
    urlStatusChecker.setURIToCheck(urlToVerify)
    assert urlStatusChecker.getHttpStatusCode() == 404

    urlToVerify = driver.findElement(By.xpath("//a[contains(., '500')]")).getAttribute("href")
    urlStatusChecker.setURIToCheck(urlToVerify)
    assert urlStatusChecker.getHttpStatusCode() == 500
}

Then(~'I verify whether I am able to access the editor'){->
    driver.findElement(By.xpath("//*[@id='mceu_15-open']")).click()

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver
    javascriptExecutor.executeScript("\$('#mceu_32-text').trigger('click')")
    driver.switchTo().frame("mce_0_ifr")
    WebElement element = driver.findElement(By.tagName("body"))
            element.sendKeys("<B>This is the bold text</B>")
    //set the content using javascript
    javascriptExecutor.executeScript("arguments[0].innerHTML = '<h1>Set text using innerHTML</h1>'", element)
}

After("@end"){
    driver.close()
}
