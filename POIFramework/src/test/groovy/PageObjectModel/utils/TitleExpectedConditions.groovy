package PageObjectModel.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition

/**
 * Created by ee on 21/08/14.
 */
class TitleExpectedConditions {


    static def currentTitle

    public TitleExpectedConditions(){

    }

    static ExpectedCondition<Boolean> isTitle(){
        return new ExpectedCondition<Boolean>() {
            private String currentTitle = "";

            @Override
            public Boolean apply(WebDriver driver) {
                currentTitle = driver.getTitle();
               // return title.equals(currentTitle);
            }

            @Override
            public String toString() {
                //return String.format("title to be \"%s\". Current title: \"%s\"", title, currentTitle);
                return "test"
            }
        };
    }

}
