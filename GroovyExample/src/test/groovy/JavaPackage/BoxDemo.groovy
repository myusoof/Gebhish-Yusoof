package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/04/14
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
class BoxDemo {
    public static void main(String[] args) {
        Box b1 = new Box(12,14,15)
        println b1.tos
        b1.height = 10
        b1.width = 11
        b1.length = 12
        Box b2 = b1
        b2.width = 14
        b1.volume()
        println b1.width
        Box b3 = new Box()
        println b3.tos
        new Thread().run()

        Runtime.runFinalizersOnExit(true)
    }
}
