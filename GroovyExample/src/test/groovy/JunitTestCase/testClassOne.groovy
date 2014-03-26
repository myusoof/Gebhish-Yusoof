package JunitTestCase

import junit.framework.TestCase

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 25/03/14
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
class testClassOne extends TestCase{
    protected int value1, value2
    protected void setUp(){
        value1=3;
        value2=3;
    }

    // test method to add two values
    public void testAdd(){
        double result= value1 + value2;
        assertTrue(result == 5);
    }

}
