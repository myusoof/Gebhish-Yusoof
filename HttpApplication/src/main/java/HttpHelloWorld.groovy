import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 22/05/14
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */

@Path("helloworld")
class HttpHelloWorld {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("path")
    void helloWorld(){
        println "hello world"
    }


}
