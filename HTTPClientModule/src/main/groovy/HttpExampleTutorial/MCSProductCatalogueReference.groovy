package HttpExampleTutorial

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.FileEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/07/14
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */

class MCSProductCatalogueReference {
    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault()

        HttpEntity entity = new FileEntity(new File("/home/yusoof/projects/Gebhish-Yusoof/HTTPClientModule/src/main/resources/userdetails.json"), ContentType.APPLICATION_JSON)
        HttpPost post = new HttpPost("http://localhost:8350/service/login")
        post.setEntity(entity)
        HttpResponse response = client.execute(post)
        println response.statusLine.statusCode
        println EntityUtils.toString(response.entity)
    }
}
