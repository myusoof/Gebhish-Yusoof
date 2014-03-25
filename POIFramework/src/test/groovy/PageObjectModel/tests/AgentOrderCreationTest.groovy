package PageObjectModel.tests
import PageObjectModel.pages.*
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

            ["447521118492","T:CR5911:UnlimitedMins:24M:15GB:SIMO:GBP38:S1","B:CR5911:15GB:DataWiFi:iPhone:INC:bolton"],
            ["447521117949","T:CR5911:UnlimitedMins:24M:15GB:SIMO:GBP38:S1","B:CR5911:15GB:DataWiFi:Smartphone:INC:bolton"] ,
            ["447521118027","T:CR5911:UnlimitedMins:24M:10GB:SIMO:GBP33:S0","B:CR5911:10GB:DataWiFi:BlackBerry7:INC:bolton"],
            ["447521118564","T:CR5911:UnlimitedMins:24M:10GB:SIMO:GBP33:S0","B:CR5911:10GB:DataWiFi:iPhone:INC:bolton"]
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
            //def deviceSKUId = it.get(3)
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",planProductId)
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(dataAllowanceProductId)

        println "${planId}, ${dataAllowanceId}"
        //WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", msisdn)
        WebDriverUtils.webBrowserStart("https://retention7:my02u4tpa55w0rd@service-stf.uk.pri.o2.com/REFMSPAFU/agent/app/home", msisdn)
        AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
        //UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
        UpgradeOptionsPage upgradeOptionsPage = new UpgradeOptionsPage()
        DeviceListHomePage deviceListHomePage = new DeviceListHomePage()
        boolean isUpgradeOptionPage = !(accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn) instanceof DeviceListHomePage)
        if(isUpgradeOptionPage){
            deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("simo")
        }
        addItemsToBasket("simo",deviceListHomePage, null,planId,dataAllowanceId,dataAllowanceProductId,null)
        DeliveryDetailsPage deliveryDetailsPage = deviceListHomePage.clickOnCheckOutButton()
        OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()
        String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
        println orderNumber
        }
    }

   /* def ccaProductId = [
            ["449999999999","T:CR5911:100Mins:24M:100MB:GBP8:S1:CCA", "B:CR5911:300MB:DataWiFi:iPhone:INC:bolton", "8234C","fullcca"]
    ]*/

    def ccaProductId = [
//            ["T:CR5911:UnlimitedMins:24M:2GB:GBP18:S1:CCA", "B:CR5911:2GB:DataWiFi:iPhone:INC:bolton", "ME499B/A","fullcca"],
           ["T:CR5911:UnlimitedMins:24M:2GB:GBP18:S1:CCA", "B:CR5911:2GB:DataWiFi:Smartphone:INC:bolton", "ffade597-08c3-4320-8446-783394f99183","nonFullCca"]
    ]

    @Test
    void ccaOrderCreation(){
        def planId, dataAllowanceId, deviceId, standardOrCCA
        ccaProductId.each {
            def planProductId = it.get(0)
            def dataAllowanceProductId = it.get(1)
            //def deviceSKUId = it.get(2)
            standardOrCCA = it.get(3)
            planId =  productDetails.getObjectIdForGivenSkuorProductId("plan",planProductId)
            dataAllowanceId =  productDetails.getDataAllowanceIdForGivenProductId(dataAllowanceProductId)
            deviceId = it.get(2)
        }
        println "${deviceId}, ${planId}, ${dataAllowanceId}"
//        WebDriverUtils.webBrowserStart("http://localhost:8090/agent/app/home", msisdn)
        WebDriverUtils.webBrowserStartAcquisition("https://retention7:my02u4tpa55w0rd@service-stf.uk.pri.o2.com/REFMSPAFU/agent/app/home?PartnerId=o2")
        AgentHomePage agentHomePage = new AgentHomePage()
        def deviceListHomePage = agentHomePage.clickOnNewCustomerNewConnection()
        /*
        UpgradeOptionsPage upgradeOptionsPage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
        DeviceListHomePage deviceListHomePage = upgradeOptionsPage.clickOnUpgradeForFreeButton("handset")*/
        addItemsToBasket(standardOrCCA,deviceListHomePage, deviceId,planId,dataAllowanceId)
        RegistrationPage registrationPage = deviceListHomePage.startCheckout()
        registrationPage.acceptAdvisorChecks()
        registrationPage.enterCreditCheckDetailsSection()
        registrationPage.updateEmailAddressSection()
        registrationPage.acceptRefreshDealSummary()
        CCALinkPage ccaLinkPage = registrationPage.generateCCA()
        String ccaLink = ccaLinkPage.getGeneratedCCALink()
        WebDriverUtils.accessCCALinkToCheckout(ccaLink)
        CheckoutLoginPage loginPage = new CheckoutLoginPage()
        loginPage.loginCustomer(registrationPage.emailId,"password-1")

        VerifyUserNamePage verifyUserNamePage = new VerifyUserNamePage()
        CCAAgreementPage ccaAgreementPage = verifyUserNamePage().clickOnContinueButton()
        ccaAgreementPage.acceptKeyInformation()
        ccaAgreementPage.acceptPayMonthlyTerms()
        ccaAgreementPage.acceptPhonePlanCCA()
        ccaAgreementPage.acceptSecci()
        CheckoutDeliveryOptionsPage deliveryOptionsPage = ccaAgreementPage.proceedToDelivery()
        OrderReviewPage reviewOrderPage = deliveryOptionsPage.clickContinueonDeliveryPage()
        reviewOrderPage.clickOnConfirmO2TermsAndConditions()
        PaymentPage paymentPage = reviewOrderPage.clickOnPayNow()
        paymentPage.enterSecurityNumber()
        OrderConfirmationPage orderConfirmationPage = paymentPage.clickOnPayNow()
        /*OrderConfirmationPage orderConfirmationPage = deliveryDetailsPage.SubmitOrder()*/
        orderConfirmationPage.verifyOrderSubmittedThroughCheckout()
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

        if(type == "nonFullCca"){
        deviceListHomePage.selectCcaPriceCombinationInBasketForNonFullCCA()
        }
        else if(type == "FullCca"){
        deviceListHomePage.selectCcaPriceCombinationInBasketForFullCCA()
        }

        deviceListHomePage.clickOnTab("extras")
        deviceListHomePage.addDataAllowanceToBasket(type, dataAllowanceId, dataAllowanceProductId,standardOrCCA)

    }


}