package Package1

import org.testng.annotations.Test

/**
 * Created by yusoof on 20/09/14.
 */
@Test(groups = "factoryTest")
class FactoryTestImpl {

    String firstName
    String lastName

    public FactoryTestImpl(){

    }
    public FactoryTestImpl(String firstName, String lastName){
        this.firstName = firstName
        this.lastName = lastName
    }

    @Test
    public final void createMethod(){
        println "fullName: ${firstName}, ${lastName}"
    }

    @Test
    public final void createMethodOne(){
        println "fullName: ${firstName}, ${lastName}"
    }

    @Test
    public final void createMethodTwo(){
        println "fullName: ${firstName}, ${lastName}"
    }


}
