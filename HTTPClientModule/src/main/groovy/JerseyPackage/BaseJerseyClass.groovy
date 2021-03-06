package JerseyPackage

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.MappingJsonFactory
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
    def resource = client.resource("http://localhost:8350/service/")
    def response
    def jSessionId

    enum RequestOfType {
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
        assert response.status  == NO_CONTENT.statusCode
        return response
    }

    ClientResponse RequestingType(String type, String path, JSONObject jsonObject, int statusCode ){
        switch(type){
           case "Post":
               response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonObject.toString())
               jSessionId = jSessionId? jSessionId : getSessionId(response.cookies.toString())
               println jSessionId
               assert response.status == statusCode
               break
            case "Get":
                jSessionId = getSessionId(response.cookies.toString())
                assert response.status == statusCode
                break
            case "Put":
                response = resource.path(path).header('Cookie', jSessionId).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, jsonObject.toString())
                jSessionId = getSessionId(response.cookies.toString())
                assert response.status == statusCode
                break
        }
        return response
    }

    Object getJsonObject(ClientResponse response){
        def outputResponse = response.getEntity(String.class)
        JsonFactory jsonFactory = new MappingJsonFactory()
        return jsonFactory.createParser(outputResponse).readValueAs(Object.class)
    }

}
