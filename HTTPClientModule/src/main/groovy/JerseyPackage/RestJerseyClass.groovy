package JerseyPackage

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.PartialRequestBuilder
import com.sun.jersey.api.client.WebResource
import net.sf.json.JSONObject
import org.junit.Test

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 14/05/14
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
class RestJerseyClass {
    Client client = Client.create()
    Map responseData = [:]
    @Test
    void testLogin(){
        final Map adminUser = ["password": "Password","username": "admin@productworks.com"]
        WebResource resource =  client.resource("http://localhost:9999/service")
        resource = resource.path("/login")
        println setHeader(resource).post(ClientResponse.class, new JSONObject(adminUser).toString())
        println resource
    }

    PartialRequestBuilder setHeader(WebResource resource,String cookieSessionId = "JSESSIONID=n6j3d6p5johpzntnkl6adadwg" ){
         return resource.header('User-Agent','Mozilla/5.0')
                 .header('Content-Type','application/json;charset=UTF-8')
                 .header('Cookie',cookieSessionId)
    }


}
