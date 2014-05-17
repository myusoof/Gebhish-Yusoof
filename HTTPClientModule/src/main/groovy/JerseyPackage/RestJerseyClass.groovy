package JerseyPackage

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

        setInitialSet()
//        requestTypeOf(requestTypeOf.POST, "dev/setInitialState", NO_CONTENT.statusCode)
        requestTypeOf(RequestType.POST, "login", adminUserDetails, OK.statusCode)
        requestTypeOf(RequestType.POST,"resetPassword", newAdminUserDetails, NO_CONTENT.statusCode)
        requestTypeOf(RequestType.POST, "login", reLoginUserDetails, OK.statusCode)
        requestTypeOf(RequestType.GET, "group", OK.statusCode)
    }

}
