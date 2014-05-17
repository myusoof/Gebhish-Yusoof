package JerseyPackage

import com.sun.jersey.api.client.Client
import static com.sun.jersey.api.client.ClientResponse.Status.*
import com.sun.jersey.api.client.ClientResponse
import net.sf.json.JSONObject

import javax.ws.rs.core.MediaType

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 17/05/14
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */
class BaseJerseyClass {

    Client client = Client.create()
    def resource = client.resource("http://localhost:9999/service/")
    def response
    def jSessionId

    enum RequestType{
        POST,
        GET,
        PUT
    }

    String getSessionId(String cookieString){
        String cookieId = null
        if(cookieString != '[]'){
            def matcher = cookieString =~/\[(.*);V.*/
            cookieId = matcher[0][1]
        }
        cookieId
    }


    ClientResponse setInitialSet(){
        response = resource.path("dev/setInitialState").post(ClientResponse.class)

        println response
        assert response.status  == NO_CONTENT.statusCode
        return response
    }

    ClientResponse requestTypeOf(RequestType type, String path, Map adminUserDetails = null, int statusCode ){
        switch(type){
           case RequestType.POST:
               response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, new JSONObject(adminUserDetails).toString())
               jSessionId = getSessionId(response.cookies.toString())
                break
            case RequestType.GET:
                response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).get(ClientResponse.class)
                println response
                jSessionId = getSessionId(response.cookies.toString())
                break
            case RequestType.PUT:
                response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, new JSONObject(adminUserDetails).toString())
                jSessionId = getSessionId(response.cookies.toString())
                break
        }
        assert response.status  == statusCode
        return response
    }

    ClientResponse getGroup(String path){
        response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).get(ClientResponse.class)
        println response
    }

}
