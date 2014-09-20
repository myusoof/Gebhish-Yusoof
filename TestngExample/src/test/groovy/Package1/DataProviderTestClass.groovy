package Package1

import org.testng.annotations.DataProvider
import org.testng.annotations.Test

/**
 * Created by yusoof on 20/09/14.
 */
class DataProviderTestClass {


    @DataProvider(name = 'dataprovider')
    Object[][] dataProviderOne(){
        def multipleArray = [
                ["a"],
                ["b"],
                ["c"]
        ]
        multipleArray
    }

    @Test(dataProvider ="dataprovider" )
    void dataProviderTestMethodOne(String a){
            println a
    }
}
