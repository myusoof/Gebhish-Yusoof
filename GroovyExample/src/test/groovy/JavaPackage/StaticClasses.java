package JavaPackage;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 05/04/14
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class StaticClasses {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.test();

        SupClass supClass;
        SubClass subClass = new SubClass(1,2,3);
        supClass = subClass;
        System.out.println(subClass.getA());
        System.out.println(subClass.getB());
        System.out.println(subClass.getC());
        System.out.println(supClass.getA());
        System.out.println(supClass.getB());
    }
}
