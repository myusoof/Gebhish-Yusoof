package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/04/14
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Given(~'I have this test method'){
    println "test Method One created"
}
