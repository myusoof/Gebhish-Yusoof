package JerseyPackage

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.MappingJsonFactory
import net.sf.json.JSON
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.junit.Test

import static com.sun.jersey.api.client.ClientResponse.Status.*

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 14/05/14
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
class RestJerseyClass extends BaseJerseyClass{

    @Test
    void testHttpClient(){
        def adminUserDetails = ["username": "sysadmin@productworks.com", "password": "Password"]
        def reLoginUserDetails = ["username": "sysadmin@productworks.com", "password": "NewPassword"]
        def newAdminUserDetails= ["username": "sysadmin@productworks.com", "password": "Password", 'newPassword': 'NewPassword']
        def groupDetails = [description: TestHelper.randomGroupName(), name: TestHelper.randomGroupName(),privileges: []]


        groupDetails.privileges+= MongoDbHelper.getPrivilegeDetails()
//        groupDetails.privileges+= ["5374681d7c260751b848815f","537468848d0c6c4c4b9dc654"]

        //setInitialSet()
        //RequestingType("Post", "login", new JSONObject(adminUserDetails), OK.statusCode)
       // RequestingType("Post","resetPassword", new JSONObject(newAdminUserDetails), NO_CONTENT.statusCode)
        RequestingType("Post", "login", new JSONObject(reLoginUserDetails), OK.statusCode)
        response = RequestingType("Get", "group",null, OK.statusCode)
        /*Object abc = getJsonObject(response)
        println abc.privileges.name*/
        RequestingType("Get", "privilege", null, OK.statusCode)
        RequestingType("Post", "group", new JSONObject(groupDetails), CREATED.statusCode)

    }


}
