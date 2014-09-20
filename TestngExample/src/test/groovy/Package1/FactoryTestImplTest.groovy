package Package1

import net.sourceforge.htmlunit.corejs.javascript.commonjs.module.provider.DefaultUrlConnectionExpiryCalculator
import org.testng.annotations.Test

/**
 * Created by yusoof on 20/09/14.
 */
class FactoryTestImplTest {

    static int op1
    static int op2
    static int result

    public FactoryTestImplTest(int op1, int op2, int result){
        this.op1 = op1
        this.op2 = op2
        this.result = result
    }

    @Test
    public static void factoryTestOne(){
        println op1
        println op2
        println result
    }
}
