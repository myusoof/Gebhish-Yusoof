package JavaPackage;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 05/04/14
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class OuterClass extends TypeConversion{
    static int a = 1;
    double ab = 2.0;

    void test(){
        TypeConversion conversion = new TypeConversion();
        conversion.getDefaultVariable();
        conversion.getDefaultVariable();
        int a = conversion.protectedVariable;
        InnerClass inner = new InnerClass();
        inner.display();
    }

    static class InnerClass{
        int abc = 1;

        void display(){
            System.out.println(a);
        }
    }
}
