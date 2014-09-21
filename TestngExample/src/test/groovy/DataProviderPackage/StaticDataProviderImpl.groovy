package DataProviderPackage

import org.testng.annotations.Test

/**
 * Created by yusoof on 21/09/14.
 */
class StaticDataProviderImpl {

    @Test(dataProvider = "age", dataProviderClass = StaticDataProvider.class)
    public void ageDataProviderImpl(String age){
        println age

    }
}
