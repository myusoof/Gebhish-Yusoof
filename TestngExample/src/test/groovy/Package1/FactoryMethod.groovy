package Package1

/**
 * Created by yusoof on 20/09/14.
 */
class FactoryMethod {

    @org.testng.annotations.Factory
    Object[] createInstance(){
        Object res = new Object[5]
        res[1] = new FactoryTestImplTest(2,2,4)
        res[2] = new FactoryTestImplTest(3,4,7)
        res
    }
}
