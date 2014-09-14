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
class TestAccountTest {

    @BeforeSuite
    void suiteMethod(){
        println "before suite"
    }

    @BeforeClass
    void beforeClass(){
        println "before class"
    }

    @AfterClass
    void afterClass(){
        println "after group"
    }

    @BeforeGroups
    void beforeGroups(){
        println "before group"
    }

    @AfterGroups
    void afterGroups(){
        println "after class"
    }

    @Test(groups = ['firstclass'])
    void  testOne() {
        println "test method"
    }

    @Test
    void  testTwo() {
        println "test method two"
    }

    @AfterSuite
    void afterSuite(){
        println "after suite"
    }
}
