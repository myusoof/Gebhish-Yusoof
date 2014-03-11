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
class OrderPlacementTest {
    //RestClient agentShopClient = new RestClient("https://ecom:ecom@prodcat.ref.o2.co.uk/")
    RestClient agentShopClient = new RestClient("http://localhost:8080/")

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

    Map<String, String> getPortalIdBasketIdForGivenMsisdn(msisdn){
        def userData
        def customerResponse = agentShopClient.get(path: "customerService/customers;type=msisdn/${msisdn}")
        def portalId= customerResponse.data.msisdns.find{it.msisdn == msisdn}.portalId
        userData = [portalId:portalId]
    }

    String getObjectIdForGivenSkuorProductId(productType, skuOrProductId){
        def productResponse
        def productId
        if(productType == "plan")  {
            productResponse = agentShopClient.get(path: "productService/admin/${productType}").data
            productId = productResponse.find{it.productID == skuOrProductId}.id
            return  productId
        }else{
            productResponse = agentShopClient.get(path: "productService/products/device/sku/${skuOrProductId}").data
            productId = productResponse.id
            return productId
        }
    }

    String getDataAllowanceIdForGivenProductId(String skuOrProductId){
        def productResponse
        if(StringUtils.containsIgnoreCase(skuOrProductId, "BlackBerry")){
            productResponse  = agentShopClient.get(path: "productService/admin/dataAllowanceGroups/Blackberry").data
            return productResponse.members.flatten().find{it.productID == skuOrProductId}.id
        }else if(StringUtils.containsIgnoreCase(skuOrProductId,"iPhone")){
            productResponse  = agentShopClient.get(path: "productService/admin/dataAllowanceGroups/iPhone").data
            return productResponse.members.flatten().find{it.productID == skuOrProductId}.id
        }else if(StringUtils.contains(skuOrProductId,"Smartphone")){
            productResponse  = agentShopClient.get(path: "productService/admin/dataAllowanceGroups/SmartPhone").data
            return productResponse.members.flatten().find{it.productID == skuOrProductId}.id
        }else{
            productResponse  = agentShopClient.get(path: "productService/admin/dataAllowanceGroups/WebDaily").data
            return productResponse.members.flatten().find{it.productID == skuOrProductId}.id
        }
    }

    protected void addProductsToBasket(String basketId,productIds) {
        //Adding the product items to basket
        productIds.each {product, Id ->
            assert agentShopClient.post(path: "basketService/baskets/${basketId}/add/${product}/${Id}").status == 204
        }
    }

    protected String createPrivateBasketForaMsisdn(msisdn){
       def response = agentShopClient.post(path:"basketService/baskets/createPrivateBasket;by=msisdn/${msisdn}").data
       response.id
    }

    protected String createOrder(basketId){
        def response = agentShopClient.post(path: "orderService/orders", body: [basketId : basketId])
        response.id
    }
    protected String continueToOrder(orderId){
        def response = agentShopClient.get(path: "orderService/orders/${orderId}").data
        response.id
    }
    protected String preSubmitOrder(orderId){
        def order = agentShopClient.post(path: "/orderService/orders/${orderId}/preSubmitOrder").data
        order
    }

}
