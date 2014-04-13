import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 11/04/14
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = ["pretty", "json:target/cucumber.json"])
class RunCukesTest {
}
