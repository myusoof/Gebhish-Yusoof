package Package1

import org.testng.annotations.Test

/**
 * Created by yusoof on 20/09/14.
 */
class FactoryTestImpl {

    static String firstName
    static String lastName

    public FactoryTestImpl(String firstName, String lastName){
        this.firstName = firstName
        this.lastName = lastName
    }

    @Test(groups = "runTest")
    public static void createMethod(){
        println "fullName: ${firstName}, ${lastName}"
    }

    @Test(groups = "runTest")
    public static void createMethodOne(){
        println "fullName: ${firstName}, ${lastName}"
    }

    @Test(groups = "runTest")
    public static void createMethodTwo(){
        println "fullName: ${firstName}, ${lastName}"
    }


}
