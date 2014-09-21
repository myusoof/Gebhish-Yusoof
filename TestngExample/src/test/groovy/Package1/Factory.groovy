package Package1

/**
 * Created by yusoof on 20/09/14.
 */
class Factory {

    @org.testng.annotations.Factory
    public Object[] createTest(){
        Object[] returnClass = [new FactoryTestImpl("Yusoof", "Mohmed"),
                                new FactoryTestImpl("ShamugamPriyan", "Gagadeeshan"),
                                new FactoryTestImpl("DineshKumar", "Damodharan"),
                                new FactoryTestImpl("Ankit", "Patnekar")]
        returnClass
    }
}
