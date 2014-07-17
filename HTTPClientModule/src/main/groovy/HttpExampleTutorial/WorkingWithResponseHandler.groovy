package HttpExampleTutorial

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.MappingJsonFactory
import com.fasterxml.jackson.core.JsonParser
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.StatusLine
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpResponseException
import org.apache.http.client.ResponseHandler
import org.apache.http.client.methods.HttpGet
import org.apache.http.conn.ConnectionKeepAliveStrategy
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.HttpContext
import org.apache.http.util.EntityUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/07/14
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithResponseHandler {
    public static void main(String[] args) {

        ConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy(){
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context){
                long keepAlive = super.getKeepAliveDuration(response, context)
                if(keepAlive == -1){
                    keepAlive = 5000
                }
                return keepAlive
            }
        }
        CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(keepAliveStrategy).build()
        HttpGet get = new HttpGet("http://the-internet.herokuapp.com/")

        ResponseHandler<String> hr = new ResponseHandler<String>() {
            @Override
            String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                StatusLine statusLine = response.getStatusLine()
                HttpEntity entity = response.entity
                if(statusLine.statusCode >=300){
                    throw new HttpResponseException(statusLine.statusCode, statusLine.reasonPhrase)
                }
                if(entity == null){
                    throw new ClientProtocolException("response contain no content")
                }
                JsonFactory jsonFactory = new MappingJsonFactory()
                JsonParser parser = jsonFactory.createParser(entity.content)
                return EntityUtils.toString(entity)
            }
        }


        String object = client.execute(get, hr)
        println object
    }
}
