import calc.Calculator1
import cucumber.api.groovy.*
import cucumber.api.groovy.Hooks

/**
 * Created with IntelliJ IDEA.
 * User: ee
` * Date: 11/04/14
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)



Calculator1 calculator1 = new Calculator1()
Given(~'I have a test to print the normal text$'){ ->
    println "test the print yusoof"
    assert true
}


Given(~'I enter( another)? (\\d?) in the calculator'){String a, int number ->
    calculator1.push(number)
    println number.toInteger()
}


When(~'I add two (\\d+) number'){ int number ->
    println calculator1.add()
}

Then(~'^I should see total of (\\d)+ in the result$') { totalNumber ->
  assert calculator1.add() == totalNumber.toDouble()
}





