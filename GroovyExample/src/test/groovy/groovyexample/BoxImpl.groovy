package groovyexample
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/08/14
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */
class BoxImpl {

    public static void main(String[] args) {

        Box<Integer> integerBox = new Box<>()
        Box rawBox = new Box()
        integerBox = rawBox
        integerBox.setT("tests")
        println integerBox.getT()

        integerBox.<Integer>genericMethod(new Integer(1))


        Box<Number> boundedClass = new Box()
        boundedClass.boundedGenericMethod(new Integer(2))
        boundedClass.boundedGenericMethod(new Long(1L))


    }
}
