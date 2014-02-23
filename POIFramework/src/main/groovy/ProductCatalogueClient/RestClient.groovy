package ProductCatalogueClient

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.MappingJsonFactory
import groovyx.net.http.ContentType
import groovyx.net.http.ParserRegistry
import groovyx.net.http.RESTClient
import org.apache.commons.io.IOUtils
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.RedirectHandler

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 23/02/14
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
class RestClient extends RESTClient{
    protected JsonFactory jsonFactory = new MappingJsonFactory()
    private RedirectHandler standardRedirectHandler
    RestClient(Object defaultURI) {
        super(defaultURI)
        encoder.charset = "UTF-8"
        parser[ContentType.JSON] = { HttpResponse resp ->
            JsonParser parser = jsonFactory.createParser(resp.entity.content)
            parser.readValueAs(Object.class)
        }

        parser["text/csv"] = { HttpResponse resp ->
            IOUtils.readLines(resp.entity.content, "utf-8").join("\n")
        }

        handler.failure = { resp ->
            HttpEntity entity = resp.getEntity();
            if (entity == null || entity.getContentLength() == 0) {
                return resp
            }
            resp.setData(parseResponse(resp, ParserRegistry.getContentType(resp)))
            resp
        }

        standardRedirectHandler = client.redirectHandler
    }

}
