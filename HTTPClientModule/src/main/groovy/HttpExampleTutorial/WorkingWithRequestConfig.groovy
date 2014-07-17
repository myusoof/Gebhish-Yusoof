package HttpExampleTutorial

import org.apache.http.HttpResponse
import org.apache.http.conn.ConnectionKeepAliveStrategy
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.HttpContext

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 17/07/14
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
class WorkingWithRequestConfig {
    public static void main(String[] args) {
        ConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy(){
            @Override
            public long getKeepAliveDuration(
                    HttpResponse response,
                    HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1) {
                    keepAlive = 5000;
                }
                return keepAlive;
            }
        }
        CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(keepAliveStrategy)
    }
}
