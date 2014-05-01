package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import groovy.transform.Field
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 30/04/14
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


WebDriver driver = new FirefoxDriver()

Given(~'^I initiated the web driver$'){->
   // driver = TestContext.getInstance()
}

When(~'^I navigate to the google home page$'){->
    driver.get("http://www.google.com");
}

When(~'^I enter value in the searchbox$'){->
    WebElement element = driver.findElement(By.name("q"))
    element.sendKeys("Cheese!")
    element.submit()

}

When(~'^I should see the result$'){->
    driver.getTitle().toLowerCase().startsWith("cheese!")
}

Then(~'^I quit the driver$'){->
    driver.quit()
}