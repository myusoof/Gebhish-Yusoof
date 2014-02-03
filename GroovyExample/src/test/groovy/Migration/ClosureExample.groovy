package Migration

import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 03/02/14
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
@Mixin(GivenWhenThen)
class ClosureExample {

    @Test
    void test1() {
        given method1
    }


    def method1 = {
        println "test"
    }
}
