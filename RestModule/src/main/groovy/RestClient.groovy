import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.MappingJsonFactory
import groovyx.net.http.ContentType
import groovyx.net.http.ParserRegistry
import groovyx.net.http.RESTClient
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 23/02/14
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
class RestClient extends RESTClient{

    public RestClient(Object defaultURI){
    super(defaultURI)
        parser[ContentType.JSON] = { HttpResponse resp ->
            JsonParser parser = new MappingJsonFactory().createParser(resp.entity.content)
            parser.readValueAs(Object.class)
        }

        handler.failure = { resp ->
            HttpEntity entity = resp.getEntity();
            if (entity == null || entity.getContentLength() == 0) {
                return resp
            }
            resp.setData(parseResponse(resp, ParserRegistry.getContentType(resp)))
            resp
        }

    }
    public static void main(String[] args) {
        RestClient client = new RestClient("http://localhost:8080");
        //client.setHeaders(['X-TouchPoint': 'cfu', 'X-UserId': 'QATest', 'X-IdType': 'Test'])

        def deviceOne = client.get([path: "/productService/products/device/345aae14-bba7-4d90-96d2-7074d223a116"])
        println deviceOne.status
        println deviceOne.data
    }
}
