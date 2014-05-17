package JerseyPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/05/14
 * Time: 00:12
 * To change this template use File | Settings | File Templates.
 */
class TestHelper {
    static MongoDbHelper mongoDbHelper = new MongoDbHelper()
    static String randomGroupName(){
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        Random random = new Random()
        print alphabets.charAt(random.nextInt(alphabets.length()))
        StringBuilder builder = new StringBuilder()
        for(int i =0;i <7;i++){
            builder.append(alphabets.charAt(random.nextInt(alphabets.length())))
        }
     builder
    }

    static Map storePrivilegeId(){
        mongoDbHelper
    }
}
