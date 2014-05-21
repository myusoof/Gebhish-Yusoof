package JavaPackage.Threading

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 21/05/14
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
class SimpleThreadExamples {
    public static void main(String[] args) {
        new SimpleThread("First thread").start()
        new SimpleThread("Second thread").start()
        new SimpleThread("Bora bora").start()
    }
}
