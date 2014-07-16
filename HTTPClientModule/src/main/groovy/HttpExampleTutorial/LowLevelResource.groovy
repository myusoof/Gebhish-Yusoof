package HttpExampleTutorial

import com.mongodb.util.JSON
import groovyx.net.http.ContentType
import jdk.nashorn.internal.parser.JSONParser
import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.BufferedHttpEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/07/14
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
class LowLevelResource {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault()

        HttpGet get = new HttpGet("http://maps.googleapis.com/maps/api/geocode/json?latlng=44.4647452,7.3553838&sensor=true")

        HttpEntity entity = client.execute(get).getEntity()
        entity = new BufferedHttpEntity(entity)
//        client.execute(get).getEntity().writeTo(new FileOutputStream("/home/yusoof/projects/Gebhish-Yusoof/HTTPClientModule/src/main/resources/TestOne.json"))
        String outputResponse = EntityUtils.toString(entity)

//        println JSON.parse(outputResponse).results[0].address_components[0].long_name

        HttpEntity entity1 = client.execute(new HttpGet("http://localhost:8350/service/user")).entity
        client.execute(new HttpPost("http://localhost:8350/service/login")).entity
        println EntityUtils.toString(entity1)
    }
}
