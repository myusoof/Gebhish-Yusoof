package FileHandling

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/03/14
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public enum TestOne {
    ONE("1", "stets"),
    TWO("2", "fsffd"),
    THREE("3", "sdfdsf")

    String value
    String value2
    TestOne(String value, String value2){
        this.value = value
        this.value2 = value2
    }

    String getValue(){
        return value
    }
    String getValue2(){
        return value2
    }
}