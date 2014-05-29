package RestServicePackageApp

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 22/05/14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
@Path("path")
class HelloRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    void HelloWorld(){
         println "hello world"
    }
}
