package ProductCatalogueClient

import org.apache.commons.lang3.StringUtils

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
class ProductDetails {

//    RestClient agentShopClient = new RestClient("http://10.200.170.15:8081/")
    RestClient agentShopClient = new RestClient("https://ecom:ecom@prodcat.ref.o2.co.uk/")
    public ProductDetails(){
        agentShopClient.setHeaders(['X-TouchPoint': 'agent', 'X-IdType': 'WebSealAccessManagerUserId','Content-Type': 'application/json','X-UserId': 'QATest','X-Channel': 'VoiceUpgrade'])
    }
    Map<String, String> getPortalIdBasketIdForGivenMsisdn(msisdn){
        def userData
        def customerResponse = agentShopClient.get(path: "customerService/customers;type=msisdn/${msisdn}")
        def portalId= customerResponse.data.msisdns.find{it.msisdn == msisdn}.portalId
        userData = [portalId:portalId]
    }

    String getObjectIdForDevice(productType, skuOrProductId){
        def productResponse
        def productId
        if(productType == "plan")  {
            productResponse = agentShopClient.get(path: "productService/admin/${productType}").data
            productId = productResponse.find{it.productID == skuOrProductId}.id
            return  productId
        }else{
            productResponse = agentShopClient.get(path: "productService/products/device/${skuOrProductId}").data
            productId = productResponse.id
            return productId
        }
    }

    String getObjectIdForPlan(planResponse, skuOrProductId){
        def productId
        productId = planResponse.find{it.productID == skuOrProductId}.id
        return  productId
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
            def response = agentShopClient.post(path: "basketService/baskets/${basketId}/add/${product}/${Id}")
            println response.data
            assert response.status == 204
        }
    }

    protected String createPrivateBasketForaMsisdn(msisdn){
        def response = agentShopClient.post(path:"basketService/baskets/createPrivateBasket;by=msisdn/${msisdn}").data
        response.id
    }

    protected String createOrder(basketId){
        def response = agentShopClient.post(path: "orderService/orders", body: [basketId : basketId]).data
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
