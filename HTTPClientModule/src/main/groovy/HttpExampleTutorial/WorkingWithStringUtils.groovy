package HttpExampleTutorial

import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.BufferedHttpEntity
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
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


        HttpClient client = HttpClients.createDefault()
        HttpGet post = new HttpGet("https://www.google.com/maps/preview?q=51.5126985,-0.5891694")

        HttpResponse response = client.execute(post)
        println EntityUtils.toString(response.entity)

    }
}
