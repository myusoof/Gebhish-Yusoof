package FileHandling

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 25/01/14
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
class StringHandling {
    public static void main(String[] args) {
        String [] test = ["test1", "test2", "test3", "test4"]
        StringBuilder sb = new StringBuilder()
        for(String i : test){
            sb.append(i+ " ")
        }
        println sb.toString()
    }
}
