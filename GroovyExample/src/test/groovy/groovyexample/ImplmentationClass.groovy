package groovyexample
/**
 * Created by yusoof on 22/10/14.
 */
class ImplmentationClass implements InterfaceOne{

    static InterfaceOne interfaceOne

    public ImplmentationClass(){
        this.interfaceOne = new ImplementationClass2()
    }

    void method1impl() {
        interfaceOne.method1impl()
    }

    String methodTwoimpl() {
        return interfaceOne.methodTwoimpl()
    }

    public static void main(String[] args) {
        ImplmentationClass implmentationClass = new ImplmentationClass()
        implmentationClass.method1impl()
        println implmentationClass.methodTwoimpl()
    }
}
