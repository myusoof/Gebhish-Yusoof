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
    def StandardProductId = [
            ["447999000100","upgrade:Q1:09:O2:15:24M:promo", "standard_and_Smartphone_works_pid", "5HTHD7XN","standard"]
    ]
    @Test
    void agentStandardOrderCreation(){
        def msisdn, planId, dataAllowanceId, deviceId, standardOrCCA
        StandardProductId.each {
            msisdn = it.get(0)
            def planProductId = it.get(1)
            def dataAllowanceProductId = it.get(2)
            def deviceSKUId = it.get(3)
            standardOrCCA = it.get(4)
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",planProductId)
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(dataAllowanceProductId)
            deviceId = productDetails.getObjectIdForGivenSkuorProductId("device", deviceSKUId)
        }
        println "${deviceId}, ${planId}, ${dataAllowanceId}"
        WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", msisdn)
        AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
        UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
        DeviceListHomePage deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("handset")
        addItemsToBasket(standardOrCCA,deviceListHomePage, deviceId,planId,dataAllowanceId)
        DeliveryDetailsPage deliveryDetailsPage = deviceListHomePage.clickOnCheckOutButton()
        OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()
        String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
        println orderNumber

    }

    def SimoProductId = [
            ["447999000100","T:CR5911:100Mins:24M:100MB:SIMO:GBP8:S1", "B:CR5911:100MB:DataWiFi:BlackBerry7:INC:bolton","fullcca"]
    ]
    /*["447999000100","T:CR5911:100Mins:24M:100MB:SIMO:GBP8:S1", "B:CR5911:100MB:DataWiFi:iPhone:INC:bolton",null],
    ["447999000100","T:CR5911:100Mins:24M:100MB:SIMO:GBP8:S1", "B:CR5911:100MB:DataWiFi:Smartphone:INC:bolton",null]*/
    @Test
    void simoAgentUpgradeOrder(){
        def msisdn, planId, dataAllowanceId, dataAllowanceProductId
        SimoProductId.each {
            def planProductId = it.get(1)
            msisdn = it.get(0)
            dataAllowanceProductId = it.get(2)
            def deviceSKUId = it.get(3)
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",planProductId)
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(dataAllowanceProductId)
        }
        println "${planId}, ${dataAllowanceId}"
        WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", msisdn)
        AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
        UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
        DeviceListHomePage deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("simo")
        addItemsToBasket("simo",deviceListHomePage, null,planId,dataAllowanceId,dataAllowanceProductId,null)
        DeliveryDetailsPage deliveryDetailsPage = deviceListHomePage.clickOnCheckOutButton()
        OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()
        String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
        println orderNumber
    }

    def ccaProductId = [
            ["449999999999","T:CR5911:100Mins:24M:100MB:GBP8:S1:CCA", "B:CR5911:300MB:DataWiFi:iPhone:INC:bolton", "8234C","fullcca"]
    ]

    @Test
    void ccaOrderCreation(){
        def msisdn, planId, dataAllowanceId, deviceId, standardOrCCA
        StandardProductId.each {
            msisdn = it.get(0)
            def planProductId = it.get(1)
            def dataAllowanceProductId = it.get(2)
            def deviceSKUId = it.get(3)
            standardOrCCA = it.get(4)
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",planProductId)
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(dataAllowanceProductId)
            deviceId = productDetails.getObjectIdForGivenSkuorProductId("device", deviceSKUId)
        }
        println "${deviceId}, ${planId}, ${dataAllowanceId}"
        WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", msisdn)
        AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
        UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
        DeviceListHomePage deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("handset")
        addItemsToBasket(standardOrCCA,deviceListHomePage, deviceId,planId,dataAllowanceId)
        DeliveryDetailsPage deliveryDetailsPage = deviceListHomePage.clickOnCheckOutButton()
        OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()
        String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
        println orderNumber

    }

    void addItemsToBasket(type,DeviceListHomePage deviceListHomePage, deviceId, planId, dataAllowanceId, dataAllowanceProductId = null,standardOrCCA = null){
        deviceListHomePage.createPrivateBasket()
        if(type != "simo"){
            deviceListHomePage.clickOnTab("devices")
            deviceListHomePage.addItemToBasket(deviceId)
        }
        deviceListHomePage.clickOnTab("plans")
        deviceListHomePage.addItemToBasket(planId)
        deviceListHomePage.clickOnTab("extras")
        deviceListHomePage.addDataAllowanceToBasket(type, dataAllowanceId, dataAllowanceProductId,standardOrCCA)

    }


}
