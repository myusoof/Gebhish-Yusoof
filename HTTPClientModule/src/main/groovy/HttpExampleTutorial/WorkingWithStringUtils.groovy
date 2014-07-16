package HttpExampleTutorial

import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.util.EntityUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/07/14
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithStringUtils {
    public static void main(String[] args) {
        StringEntity stringEntity = new StringEntity("This is the string", ContentType.APPLICATION_JSON)
        println stringEntity.contentLength
        println EntityUtils.toString(stringEntity)
        println stringEntity.contentType
    }
}
