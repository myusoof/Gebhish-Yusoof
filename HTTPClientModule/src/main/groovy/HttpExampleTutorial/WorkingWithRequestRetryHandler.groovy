package HttpExampleTutorial

import org.apache.http.HttpEntity
import org.apache.http.HttpEntityEnclosingRequest
import org.apache.http.HttpException
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.HttpResponse
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpRequestRetryHandler
import org.apache.http.client.ResponseHandler
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.conn.ConnectTimeoutException
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.client.LaxRedirectStrategy
import org.apache.http.protocol.HttpContext
import org.apache.http.protocol.HttpRequestInterceptorList

import javax.net.ssl.SSLException
import java.util.concurrent.atomic.AtomicInteger


/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 17/07/14
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithRequestRetryHandler {
    public static void main(String[] args) {

        LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
        HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
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
                if (idempotent) {
                    return true
                }
                return false
            }
        }

        HttpRequestInterceptor httpRequestInterceptor = new HttpRequestInterceptor() {
            @Override
            void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                AtomicInteger count = (AtomicInteger) context.getAttribute("count")
                request.addHeader("count", Integer.toString(count.getAndIncrement()))
            }
        }

        CloseableHttpClient client = HttpClients.custom().setRetryHandler(retryHandler).addInterceptorLast(httpRequestInterceptor)
                .setRedirectStrategy(redirectStrategy).build()

        ResponseHandler<String> hr = new ResponseHandler<String>() {
            @Override
            String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                return "Yusoof"
            }
        }
        AtomicInteger count = new AtomicInteger(0)
        HttpClientContext clientContext = HttpClientContext.create()
        clientContext.setAttribute("count", count)

        HttpGet get = new HttpGet("http://the-internet.herokuapp.com/")
        for (int i = 0; i <= 10; i++) {
            HttpResponse response= client.execute(get, clientContext)
            HttpEntity entity = response.entity
            println clientContext.getAttribute("count")
            response.close()
        }
    }
}
