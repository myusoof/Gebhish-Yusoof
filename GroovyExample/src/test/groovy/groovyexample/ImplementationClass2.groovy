package groovyexample
/**
 * Created by yusoof on 22/10/14.
 */
class ImplementationClass2 implements InterfaceOne{

    void method1impl() {
        println "methodimpl1"
    }


    String methodTwoimpl() {
        return "this is the return string"
    }
}
