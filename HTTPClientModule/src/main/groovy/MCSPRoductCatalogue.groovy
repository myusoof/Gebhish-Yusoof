import org.apache.http.HttpResponse
import org.junit.Test


/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 14/05/14
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
class MCSPRoductCatalogue {

    RestClient restClient
    @Test
    void testHttpClient(){
        restClient = new RestClient("http://localhost:9999/")
        restClient.setHeaders(['User-Agent:': 'Mozilla/5.0','Content-Type':'application/json;charset=UTF-8', 'Cookie': 'JSESSIONID=n6j3d6p5johpzntnkl6adadwg' ])
        HttpResponse response = restClient.post(path: "service/login", body: ["password": "Password","username": "admin@productworks.com"])
        println response

    }
}
