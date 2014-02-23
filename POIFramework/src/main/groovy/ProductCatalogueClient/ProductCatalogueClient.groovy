package ProductCatalogueClient

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 23/02/14
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
class ProductCatalogueClient extends RestClient{
    RestClient contextFreeShopClient = new RestClient("http://localhost:8080/")
    ProductCatalogueClient(Object defaultURI) {
        super(defaultURI)
        this.setHeaders(['X-TouchPoint': 'cfu', 'X-UserId': 'QATest', 'X-IdType': 'Test'])
    }


}
