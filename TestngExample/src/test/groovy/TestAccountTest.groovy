import org.testng.annotations.AfterClass
import org.testng.annotations.AfterGroups
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeGroups
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test

/**
 * Created by yusoof on 14/09/14.
 */
@Test(groups = "classGroup")
class TestAccountTest {

    int i = 0
    @Test(groups = "runTest", invocationCount = 10, enabled = true)
    public void testAccountClassMethodOne(){
        i++
        println i
    }
}
