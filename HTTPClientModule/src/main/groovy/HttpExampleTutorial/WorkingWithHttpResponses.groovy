package HttpExampleTutorial

import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.HttpVersion
import org.apache.http.message.BasicHttpResponse

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/07/14
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithHttpResponses {
    public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK,"this is the reason")
        println response.getStatusLine().toString()
        println response.entity.contentType
        println response.entity.contentLength
    }
}
