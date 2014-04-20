/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 17/04/14
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
class MapToList {
    public static void main(String[] args) {
        def map1 = [1:2, 3:4, yusoof: "yusoof1", mumtaz: "Ammma"]
        def list1 = []
        map1.each {key, value ->
            list1 << key
        }
        println list1

        println map1.keySet()
        println map1.values()
        println map1.entrySet() instanceof Set
    }

}
