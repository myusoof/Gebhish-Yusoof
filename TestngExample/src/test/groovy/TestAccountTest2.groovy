import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * Created by yusoof on 15/09/14.
 */
class TestAccountTest2 {

    @Test(groups = "runTest")
    void SecondClassTestOne(){
        println "SecondClassTestOne"
    }

    @BeforeClass
    void beforeClass(){
        println "before class"
    }

    @AfterClass
    void afterClass(){
        println "after class"
    }
}
