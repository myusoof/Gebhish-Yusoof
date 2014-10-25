package groovyexample
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 30/08/14
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */

// add a method which should return count of respective character
// ("abaaaaa") -->4
// ("accadfafdf) -->  2
class TestOne {
    public static void main(String[] args) {
        countOfRepeatedCharacters("Yusoof")
    }

    static Integer countOfRepeatedCharacters(String stringValue) {
        int returnValue = 0
        for(int i=0;i < stringValue.length(); i++){

        }

        return returnValue
    }
}
