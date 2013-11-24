package FileHandling

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 21/11/13
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */
class TestClassStatic {
    static int a = 1
    static TestClassStatic testClassStatic = new TestClassStatic()
    static TestClassStatic testClassStatic1 = new TestClassStatic()
    public static void main(String ...args){
         println testClassStatic.a
         testClassStatic.a = 2
        println testClassStatic1.a
    }

    private Integer rukhsar(){

    }
}
