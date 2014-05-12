package steps

import Helper.WebDriverHelper
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import groovy.transform.Field
import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver


/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/05/14
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
/*
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

@Field
HtmlUnitDriver driver = WebDriverHelper.getInstance(WebDriverHelper.WebDriverType.HTML)

Given(~'I am on the htmlPage'){->
    println driver.webClient.getPage("http://the-internet.herokuapp.com/status_codes/200").getWebResponse().contentType
}*/
