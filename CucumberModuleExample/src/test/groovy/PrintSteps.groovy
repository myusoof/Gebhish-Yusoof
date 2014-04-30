import calc.Calculator1
import cucumber.api.DataTable
import cucumber.api.Scenario
import cucumber.api.groovy.*
import cucumber.api.groovy.Hooks
import groovy.json.JsonBuilder
import groovy.transform.Field

import javax.ws.rs.client.WebTarget

/**
 * Created with IntelliJ IDEA.
 * User: ee
` * Date: 11/04/14
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


@Field
Scenario scenario = null

Before { Scenario currentScenario ->
    this.scenario = currentScenario
}

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

Given(~'I have a test user'){ ->
    println "I am in the test user method"
}
When(~'I login with different ([a-zA-Z]+)'){String username ->
    println username
}

/*
Given(~''){ test->
    println test instanceof List
}
*/

Given(~"I am available on \"(.+)\""){List<String> days ->
    // Do something with the days
}

Given(~'I have a with property'){->
    println "this is the text"

}

Given(~'I should see the property with:$'){DataTable table ->
    table.raw().each{
        scenario.write("<details><summary>${it[0]}</summary><pre style='margin: 0'>${it[1]}</pre></details>")
    }

}
