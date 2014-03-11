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
    RestClient agentShopClient = new RestClient("https://ecom:ecom@prodcat.ref.o2.co.uk/")

    @BeforeClass
    void setup(){
        agentShopClient.setHeaders(['X-TouchPoint': 'agent', 'X-IdType': 'WebSealAccessManagerUserId','Content-Type': 'application/json','X-UserId': 'QATest','X-Channel': 'VoiceUpgrade'])
    }
    @Test
    void getTheOrderPlaced(){
        def productDetails = [
                ["447521118362","T:CR5911:100Mins:24M:100MB:GBP8:S1:CCA", "B:CR5911:100MB:DataWiFi:BlackBerry7:INC:bolton", "1RISAMBN"]]
        def response = agentShopClient.get(path: "productService/admin/monitoring")
        println response.status
        productDetails.each {
            def customerResponse = agentShopClient.get(path: "customerService/customers;type=msisdn/${it.get(0)}")
            println customerResponse.data
            println getPortalIdBasketIdForGivenMsisdn(it.get(0)).portalId
            println getObjectIdForGivenSkuorProductId("plan",it.get(1))
            println getDataAllowanceIdForGivenProductId(it.get(2))
            println getObjectIdForGivenSkuorProductId("device", it.get(3))

            createPrivateBasketForaMsisdn()
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

    protected void addProductsToBasket(String basketLink, List<Object> products) {
        //Adding the product items to basket
        products.each {
            assert agentShopClient.post(path: "${basketLink}/add/${it.basketRef}").status == 204
        }

        def basketResponse = client.get(path: basketLink)
        assert basketResponse.status == 200
    }

    protected String createPrivateBasketForaMsisdn(msisdn){
       def response = agentShopClient.post(path:"basketService/baskets/createPrivateBasket;by=msisdn/${msisdn}").data
       response.links.find{it.rel == "urn:o2:privateBasket"}.id
    }

}
