import cucumber.api.groovy.*
import cucumber.api.groovy.Hooks

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 11/04/14
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
Given(~'I have a test to print the normal text$'){ ->
    println "test the print yusoof"
    assert true
}

When(~'I add two (\\d+) number'){ number ->
     println number.toInteger() + number.toInteger()
}


