package Package1

/**
 * Created by yusoof on 20/09/14.
 */
class Factory {

    @org.testng.annotations.Factory
    public Object[] createTest(){
        Object[] returnClass = [new FactoryTestImpl(1,1,2), new FactoryTestImpl(5,6,7)]
        returnClass
    }
}
