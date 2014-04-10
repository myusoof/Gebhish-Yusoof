package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/04/14
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
class dowhileconversion {
    public static void main(String[] args) throws Exception {
/*
        for(int i = 0; i <=10; i++){
            print "pass ${i} : "
            for(int j =0; j< 10; j++){
                print "${j} "
            }
            println ""
        }
*/

        for(int i = 0; i <=100; i++){
            for(int j = i; j <=100; j++){
                print "."
            }
            println ""
        }

    }
}
