package PageObjectModel.tests

import PageObjectModel.pages.AccountSelectionPage
import PageObjectModel.pages.DeliveryDetailsPage
import PageObjectModel.pages.DeviceListHomePage
import PageObjectModel.pages.OrderConfirmationPage
import PageObjectModel.pages.UpgradeOptionsPage
import PageObjectModel.utils.WebDriverUtils
import ProductCatalogueClient.ProductDetails
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
class AgentOrderCreationTest {
    ProductDetails productDetails = new ProductDetails()
    def productIds = [
            ["447999000100","upgrade:Q1:09:O2:15:24M:promo", "standard_and_Smartphone_works_pid", "5HTHD7XN"]]
    @Test
    void testOrderCreation(){
        def planId, dataAllowanceId, deviceId
        productIds.each {
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",it.get(1))
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(it.get(2))
            deviceId = productDetails.getObjectIdForGivenSkuorProductId("device", it.get(3))
        }
        println "${deviceId}, ${planId}, ${dataAllowanceId}"
        WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", "449999999999")
        AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
        UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn("449999999999")
        DeviceListHomePage deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("handset")
        addItemsToBasket(deviceListHomePage, deviceId,planId,dataAllowanceId)
        DeliveryDetailsPage deliveryDetailsPage = deviceListHomePage.clickOnCheckOutButton()
        OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()
        String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
        println orderNumber

    }

    void addItemsToBasket(DeviceListHomePage deviceListHomePage, deviceId, planId, dataAllowanceId){
        deviceListHomePage.clickOnTab("devices")
        deviceListHomePage.createPrivateBasket()
        deviceListHomePage.addItemToBasket(deviceId)
        deviceListHomePage.clickOnTab("plans")
        deviceListHomePage.addItemToBasket(planId)
        deviceListHomePage.clickOnTab("extras")
        deviceListHomePage.addDataAllowanceToBasket(dataAllowanceId)
    }
}
