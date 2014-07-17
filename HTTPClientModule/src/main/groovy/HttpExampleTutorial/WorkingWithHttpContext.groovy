package HttpExampleTutorial

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.BasicHttpContext
import org.apache.http.protocol.HttpContext

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/07/14
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithHttpContext {
    public static void main(String[] args) {

        HttpContext context = new BasicHttpContext()

        HttpClientContext clientContext = HttpClientContext.adapt(context);

        HttpClient client = HttpClients.createDefault()
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000).build()
        HttpGet httpGet1 = new HttpGet("http://the-internet.herokuapp.com/abtest")
        httpGet1.setConfig(requestConfig)
        CloseableHttpResponse response1 = client.execute(httpGet1, context)
        try {
            HttpEntity entity1 = response1.getEntity();
        } finally {
            response1.close();
        }

        HttpGet httpget2 = new HttpGet("http://the-internet.herokuapp.com/checkboxes");
        CloseableHttpResponse response2 = client.execute(httpget2, context);
        try {
            HttpEntity entity2 = response2.getEntity();
            println clientContext.getResponse().entity.content.readLines()
        } finally {
            response2.close();
        }


    }
}
