import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.core.Predef.bootstrap._
import com.excilys.ebi.gatling.http.Predef._
import assertions._
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 02/08/14
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
class FirstGatlingTest extends Simulation{
  val httpConf =httpConfig.baseURL("http://localhost:8080/productService/")
    .acceptHeader("application/json")

  val scn = scenario("test").repeat(10){
      exec(http("Monitoring url").get("admin/monitoring"))
  }
  setUp(scn.users(2).protocolConfig(httpConf))

  assertThat(
      global.failedRequests.count.is(0)
  )
}
