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
        rawBox = integerBox
        integerBox.setT(12)
        println rawBox.getT()
        println integerBox.getT()

    }
}
