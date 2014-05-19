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


        println groupDetails.privileges+= MongoDbHelper.getPrivilegeDetails()

        println groupDetails

        setInitialSet()
        RequestingType("Post", "login", adminUserDetails, OK.statusCode)
        RequestingType("Post","resetPassword", newAdminUserDetails, NO_CONTENT.statusCode)
        RequestingType("Post", "login", reLoginUserDetails, OK.statusCode)
        response = RequestingType("Get", "group", OK.statusCode)
        Object abc = getJsonObject(response)
        println abc.privileges.name
        RequestingType("Get", "privilege", OK.statusCode)
        RequestingType("Post", "group", groupDetails, CREATED.statusCode)

    }


}
