package HttpExampleTutorial

import org.apache.http.HttpEntityEnclosingRequest
import org.apache.http.HttpRequest
import org.apache.http.HttpResponse
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpRequestRetryHandler
import org.apache.http.client.ResponseHandler
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.conn.ConnectTimeoutException
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.HttpContext

import javax.net.ssl.SSLException


/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 17/07/14
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithRequestRetryHandler {
    public static void main(String[] args) {

        HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception,int executionCount,HttpContext context) {
                if (executionCount >= 5) {
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context)
                HttpRequest request = clientContext.getRequest()
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest)
                if(idempotent){
                    return true
                }
                return false
            }
        }

        CloseableHttpClient client = HttpClients.custom().setRetryHandler(retryHandler).build()

        ResponseHandler<String> hr = new ResponseHandler<String>() {
            @Override
            String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                return "Yusoof"
            }
        }
        HttpGet get = new HttpGet("http://the-internet.herokuapp.com/")
        String a = client.execute(get, hr)
        println a
    }
}
