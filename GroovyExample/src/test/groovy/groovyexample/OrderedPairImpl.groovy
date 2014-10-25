package groovyexample
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/08/14
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
class OrderedPairImpl {
    public static void main(String[] args) {

        OrderedPair<Integer, String> pair1 = new OrderedPair<Integer, String>(1, "343q4")
        OrderedPair<String, String> pair2 = new OrderedPair<String, String>("tressetet", "eststtat")
        println pair1.k
        println pair1.v

        println pair2.k
        println pair2.v

    }
}
