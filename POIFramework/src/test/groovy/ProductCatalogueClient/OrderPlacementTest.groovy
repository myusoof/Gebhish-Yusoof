package ProductCatalogueClient

import org.apache.commons.lang3.StringUtils
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test



/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 11/03/14
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
class OrderPlacementTest extends ProductDetails{
    //RestClient agentShopClient = new RestClient("https://ecom:ecom@prodcat.ref.o2.co.uk/")


    @BeforeClass
    void setup(){
        agentShopClient.setHeaders(['X-TouchPoint': 'agent', 'X-IdType': 'WebSealAccessManagerUserId','Content-Type': 'application/json','X-UserId': 'QATest','X-Channel': 'VoiceUpgrade'])
    }
    @Test
    void getTheOrderPlaced(){
        def productDetails = [
                ["447999000100","upgrade:Q1:09:O2:15:24M:promo", "standard_webdaily_pid", "5HTHD7XN"]]
        def response = agentShopClient.get(path: "productService/admin/monitoring")
        println response.status
        productDetails.each {
            def customerResponse = agentShopClient.get(path: "customerService/customers;type=msisdn/${it.get(0)}")
            println customerResponse.data
            def portalId =  getPortalIdBasketIdForGivenMsisdn(it.get(0)).portalId
            def planId =  getObjectIdForGivenSkuorProductId("plan",it.get(1))
            def dataAllowanceId =  getDataAllowanceIdForGivenProductId(it.get(2))
            def deviceId = getObjectIdForGivenSkuorProductId("device", it.get(3))
            def productIds = [plan : planId, device: deviceId, dataallowance: dataAllowanceId]
            def privateBasketId = createPrivateBasketForaMsisdn(it.get(0))
            println privateBasketId
            addProductsToBasket(privateBasketId, productIds)
            def orderId = createOrder(privateBasketId)
            continueToOrder(orderId)
            preSubmitOrder(orderId)
        }
    }

}
