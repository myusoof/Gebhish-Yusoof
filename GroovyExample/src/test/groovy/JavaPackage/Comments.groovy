package JavaPackage

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/04/14
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Comments {
    int value1()
    String author() default "yusoof"
    String currentDate() default "NA"
}