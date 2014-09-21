package DataProviderPackage

import org.testng.annotations.DataProvider

/**
 * Created by yusoof on 21/09/14.
 */
public class StaticDataProvider {

    @DataProvider(name = "age")
    public static Object[][] ageProvider(){
        def age = [["2"],["3"], ["4"]]
        age
    }
}
