package ProductCatalogueClient

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 23/02/14
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
class ProductCatalogueClient extends RestClient{
        ProductCatalogueClient(Object defaultURI) {
        super(defaultURI)
        this.setHeaders(['X-TouchPoint': 'cfu', 'X-IdType': 'IdentityUID','Content-Type': 'application/json','X-UserId': 'QATest','X-Channel': 'ConsumerUpgrade'])
    }


}
