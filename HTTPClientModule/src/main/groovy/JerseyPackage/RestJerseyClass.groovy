package JerseyPackage

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.MappingJsonFactory
import com.sun.jersey.api.client.ClientResponse
import net.sf.json.JSON
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.bson.types.ObjectId
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

    /*def adminUserDetails = ["username": "sysadmin@productworks.com", "password": "Password"]
    def reLoginUserDetails = ["username": "sysadmin@productworks.com", "password": "NewPassword"]
    def newAdminUserDetails= ["username": "sysadmin@productworks.com", "password": "Password", 'newPassword': 'NewPassword']*/

    @Test
    void testHttpClient(){

        String groupName = MongoDbHelper.randomGroupName()
        def groupDetails = [description: groupName, name: groupName ,privileges: []]

//        groupDetails.privileges = MongoDbHelper.getPrivilegeDetails("AllMenus")
//        groupDetails.privileges = MongoDbHelper.getPrivilegeDetails("Dev")
//        groupDetails.privileges+= ["5374681d7c260751b848815f","537468848d0c6c4c4b9dc654"]


        groupDetails.privileges = MongoDbHelper.getPrivilegeDetails()
        setInitialSet()
        println new JSONObject(groupDetails).toString()
        loginAndResetPassword("sysadmin@productworks.com", "Password", "NewPassword")
        response = RequestingType("Get", "group",null, OK.statusCode)
       // RequestingType("Get", "privilege", null, OK.statusCode)
        // Create a group
        RequestingType("Post", "group", new JSONObject(groupDetails), OK.statusCode)
        // Create a user with the group
        ObjectId groupId = MongoDbHelper.getGroupId(groupName)
        def userDetails = ["username": "privilegename@products.com", "fullName": "privilegeName", "groups": []]
        userDetails.groups << groupId.toString()
        println new JSONObject(userDetails).toString()
        RequestingType("Post", "user", new JSONObject(userDetails), OK.statusCode)
        RequestingType("Post", "logout",null, UNAUTHORIZED.statusCode)


        //try to login with the newly created username and password
        println "relogin with the new user created"
        loginAndResetPassword("privilegename@products.com", "Password", "NewPassword")
    }

    ClientResponse loginAndResetPassword(String username,String password,String newPassword){
        def adminUserDetails = ["username": username, "password": password]
        def newAdminUserDetails= ["username": username, "password": password, 'newPassword': newPassword]
        def reLoginUserDetails = ["username": username, "password": newPassword]

        RequestingType("Post", "login", new JSONObject(adminUserDetails), OK.statusCode)
        RequestingType("Post", "persistAppState", new JSONObject(adminUserDetails), OK.statusCode)
        RequestingType("Post","resetPassword", new JSONObject(newAdminUserDetails), NO_CONTENT.statusCode)
        RequestingType("Post", "login", new JSONObject(reLoginUserDetails), OK.statusCode)
    }
}

