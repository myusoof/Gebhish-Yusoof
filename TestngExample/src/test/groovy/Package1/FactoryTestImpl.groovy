package Package1

import org.testng.annotations.Test

/**
 * Created by yusoof on 20/09/14.
 */
class FactoryTestImpl {

    int op1
    int op2
    int result

    public FactoryTestImpl(int op1, int op2, int result){
        this.op1 = op1
        this.op2 = op2
        this.result = result
    }

    @Test
    public final void createMethod(){
        println op1
        println op2
        println result
    }


}
