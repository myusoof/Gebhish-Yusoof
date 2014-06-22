package Helper

import org.apache.http.client.methods.*

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/06/14
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public enum RequestMethod {
    OPTIONS(new HttpOptions()),
    GET(new HttpGet()),
    HEAD(new HttpHead()),
    POST(new HttpPost()),
    PUT(new HttpPut()),
    DELETE(new HttpDelete()),
    TRACE(new HttpTrace());

    private final HttpRequestBase requestMethod;

    RequestMethod(HttpRequestBase requestMethod) {
        this.requestMethod = requestMethod;
    }

    public HttpRequestBase getRequestMethod() {
        return this.requestMethod;
    }
}
