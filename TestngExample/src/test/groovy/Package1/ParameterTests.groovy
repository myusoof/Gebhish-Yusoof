package Package1

import org.testng.annotations.Optional
import org.testng.annotations.Parameters
import org.testng.annotations.Test


/**
 * Created by yusoof on 21/09/14.
 */
class ParameterTests {

    @Parameters(["first-name"])
    @Test
    public void parameterTest(String firstName){
        println firstName

    }

    @Parameters(["first-name12"])
    @Test
    public void parameterTestTwo(@Optional('first-name') String firstName){
        println firstName

    }
}
