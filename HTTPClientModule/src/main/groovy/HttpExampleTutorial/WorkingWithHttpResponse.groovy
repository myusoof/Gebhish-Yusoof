package HttpExampleTutorial

import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.BufferedHttpEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/07/14
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithHttpResponse {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault()
        https://www.google.co.uk/?gfe_rd=cr&ei=qnHFU9-ZJYXR8gf2toDwCQ&gws_rd=ssl
        URI uri = new URIBuilder().setScheme("http").setHost("google.co.uk").setPath("/")
        .setParameter("gfe_rd", "cr").setParameter("ei", "qnHFU9-ZJYXR8gf2toDwCQ")
        .setParameter("gws_rd", "ssl").build()
        println uri
        HttpGet get = new HttpGet(uri)
        HttpEntity entity =  client.execute(get).entity

        entity = new BufferedHttpEntity(entity)
        println entity.getContentLength()
        println entity.getContentType()
//        println entity.getContent().readLines()

       // println EntityUtils.toString(entity)
//        println entity.content.readLines()
    }
}
                                        