package JavaPackage

import java.lang.annotation.Annotation
import java.lang.reflect.Method

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/04/14
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */

class AnnotationExample {
    public static void main(String[] args) {
        myAnnoMethod()
    }

    @Comments(value1 = 1)
    static void myAnnoMethod(){
        AnnotationExample anno = new AnnotationExample()
        try{
            Class class1 = anno.getClass()
            Method method1 = class1.getMethod("myAnnoMethod")
            Comments annotation = method1.getAnnotation(AnnotationExample.class)
            println annotation.value1()
        }catch (Exception e){
            println e
        }
    }
}
