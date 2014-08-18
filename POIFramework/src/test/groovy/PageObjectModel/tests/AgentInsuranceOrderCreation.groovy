package PageObjectModel.tests

import PageObjectModel.pages.AccountSelectionPage
import PageObjectModel.pages.AgentHomePage
import PageObjectModel.pages.DeviceListHomePage
import PageObjectModel.pages.OrderConfirmationPage
import PageObjectModel.pages.PaymentPage
import PageObjectModel.pages.RegistrationPage
import PageObjectModel.pages.UpgradeOptionsPage
import PageObjectModel.utils.WebDriverUtils
import ProductCatalogueClient.ProductDetails
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

/**
 * Created by ee on 18/08/14.
 */
class AgentInsuranceOrderCreation extends ProductDetails {

    @DataProvider(name = 'productName')
    public Object[][] productNameDetails(){
        Object[][] productNameVariable = [
                ['06a1dddc-2740-49ee-b383-d2578c755f5a','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['06a1dddc-2740-49ee-b383-d2578c755f5a','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['5394f4aa-9755-40e2-ba32-b51154ce7b60','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['5394f4aa-9755-40e2-ba32-b51154ce7b60','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['3e354a2d-508f-4cec-a5fa-27a2d69781cb','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['3e354a2d-508f-4cec-a5fa-27a2d69781cb','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['daa490b8-a46d-4968-aaeb-b5b7a541ee58','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['daa490b8-a46d-4968-aaeb-b5b7a541ee58','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],


                ['39e7bc44-1151-4def-a20b-1560d12d6ee3','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['39e7bc44-1151-4def-a20b-1560d12d6ee3','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['6589c13a-1bec-4d19-962a-29ffc700d1e1','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['6589c13a-1bec-4d19-962a-29ffc700d1e1','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['a2e60f0a-eca6-4716-91c5-c1b825457093','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['a2e60f0a-eca6-4716-91c5-c1b825457093','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['fe8e1f43-d034-4708-b8b2-0632e76646a4','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['fe8e1f43-d034-4708-b8b2-0632e76646a4','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['a9ed43b2-79e8-4436-a216-92a27c803917','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['a9ed43b2-79e8-4436-a216-92a27c803917','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['ff22ff3d-2e0d-4403-ace0-34eb64b91a10-b','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['ff22ff3d-2e0d-4403-ace0-34eb64b91a10-b','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['ec60a98d-f80f-40c8-8aed-8a4fadd41ea4-p','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['ec60a98d-f80f-40c8-8aed-8a4fadd41ea4-p','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['3ded27d9-407b-4857-be73-12615b18287d','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['3ded27d9-407b-4857-be73-12615b18287d','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['68d8d6a1-41f6-410c-a295-d9912298ec31','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['68d8d6a1-41f6-410c-a295-d9912298ec31','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['8ac73d87-7551-452f-9288-fbf1e5c9eab0','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['8ac73d87-7551-452f-9288-fbf1e5c9eab0','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],


                ['cb3f6d60-e086-430e-9a7f-a6c971a466a5','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['cb3f6d60-e086-430e-9a7f-a6c971a466a5','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['f1943bda-3674-4706-a975-09be2fd4019e','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['f1943bda-3674-4706-a975-09be2fd4019e','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae']
        ]
        productNameVariable
    }

    @DataProvider(name = 'AcqProductName')
    Object[][] acqProductName(){
        Object[][] AcqProductName = [
                ['447521006991', '06a1dddc-2740-49ee-b383-d2578c755f5a','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521006864', '06a1dddc-2740-49ee-b383-d2578c755f5a','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521100241', '5394f4aa-9755-40e2-ba32-b51154ce7b60','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521007260', '5394f4aa-9755-40e2-ba32-b51154ce7b60','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521100127','3e354a2d-508f-4cec-a5fa-27a2d69781cb','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521007100', '3e354a2d-508f-4cec-a5fa-27a2d69781cb','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007217', 'daa490b8-a46d-4968-aaeb-b5b7a541ee58','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447709407522', 'daa490b8-a46d-4968-aaeb-b5b7a541ee58','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],


                ['447521118152','39e7bc44-1151-4def-a20b-1560d12d6ee3','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521117987', '39e7bc44-1151-4def-a20b-1560d12d6ee3','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521118492','6589c13a-1bec-4d19-962a-29ffc700d1e1','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521117949','6589c13a-1bec-4d19-962a-29ffc700d1e1','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521118489','a2e60f0a-eca6-4716-91c5-c1b825457093','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521118585', 'a2e60f0a-eca6-4716-91c5-c1b825457093','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521116220','fe8e1f43-d034-4708-b8b2-0632e76646a4','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521100967', 'fe8e1f43-d034-4708-b8b2-0632e76646a4','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521118438', 'a9ed43b2-79e8-4436-a216-92a27c803917','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521007171', 'a9ed43b2-79e8-4436-a216-92a27c803917','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521103358', 'ff22ff3d-2e0d-4403-ace0-34eb64b91a10-b','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521103205', 'ff22ff3d-2e0d-4403-ace0-34eb64b91a10-b','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007387', 'ec60a98d-f80f-40c8-8aed-8a4fadd41ea4-p','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521100054', 'ec60a98d-f80f-40c8-8aed-8a4fadd41ea4-p','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007457', '3ded27d9-407b-4857-be73-12615b18287d','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521100110', '3ded27d9-407b-4857-be73-12615b18287d','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007069', '68d8d6a1-41f6-410c-a295-d9912298ec31','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521100346', '68d8d6a1-41f6-410c-a295-d9912298ec31','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007393', '8ac73d87-7551-452f-9288-fbf1e5c9eab0','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521007053', '8ac73d87-7551-452f-9288-fbf1e5c9eab0','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],


                ['447521006824', 'cb3f6d60-e086-430e-9a7f-a6c971a466a5','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521100220', 'cb3f6d60-e086-430e-9a7f-a6c971a466a5','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae'],

                ['447521007260', 'f1943bda-3674-4706-a975-09be2fd4019e','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '9b00f110-adb4-48f0-83ed-386a20b1d0fc'],
                ['447521007053', 'f1943bda-3674-4706-a975-09be2fd4019e','9a47209f-c168-481c-9de9-b84f54043b2c','sp-5b7df398-2cae-4f83-8c07-7882c08c722f', '742e279c-3baa-47ff-8a97-ae76986621ae']
        ]
        AcqProductName
    }


    @Test(dataProvider = 'productName')
    void placingAgentOrderWithInsurancePromotion( String deviceId, String planId, String dataAllowanceId , String insuranceId){
        try {
            WebDriverUtils.webBrowserStartAcquisition("https://retention7:my02u4tpa55w0rd@service-stf.uk.pri.o2.com/REFMSPAFU/agent/app/home?PartnerId=o2")
            AgentHomePage agentHomePage = new AgentHomePage()
            def deviceListHomePage = agentHomePage.clickOnNewCustomerNewConnection()
            deviceListHomePage.clickOnTab("devices")
            deviceListHomePage.addItemToBasket(deviceId)
            deviceListHomePage.clickOnTab("plans")
            deviceListHomePage.addItemToBasket(planId)
            deviceListHomePage.selectCcaPriceCombinationInBasketForFullCCA()
            deviceListHomePage.clickOnTab("extras")
            deviceListHomePage.addDataAllowanceItemToBasket(dataAllowanceId)
            deviceListHomePage.addItemToBasket(insuranceId)

            RegistrationPage registrationPage = deviceListHomePage.startCheckout()
            registrationPage.acceptAdvisorChecks()
            registrationPage.enterCreditCheckDetailsSection()

            PaymentPage paymentPage = registrationPage.clickPayByCard()
            paymentPage.enterSecurityNumber()
            OrderConfirmationPage orderConfirmationPage = paymentPage.clickOnPayNow()
            String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
            println "${deviceId}, ${planId}, ${dataAllowanceId}, ${insuranceId}, ${orderNumber}"
        }finally {
            WebDriverUtils.closeWebDriver()
        }
    }


    @Test(dataProvider = 'AcqProductName')
    void placingAcqAgentOrderWithInsurancePromotion(String msisdn, String deviceId, String planId, String dataAllowanceId , String insuranceId){
        try {
            WebDriverUtils.webBrowserStartAcquisition("https://retention7:my02u4tpa55w0rd@service-stf.uk.pri.o2.com/REFMSPAFU/agent/app/home?PartnerId=o2")
            AgentHomePage agentHomePage = new AgentHomePage()
            AccountSelectionPage accountSelectionPage = new AccountSelectionPage()
            accountSelectionPage.enterTheMsisdnForSearch(msisdn)
            DeviceListHomePage deviceListHomePage = accountSelectionPage.clickOnUpgradeButtonForMsisdn(msisdn)
            deviceListHomePage.clickOnTab("devices")
            deviceListHomePage.addItemToBasket(deviceId)
            deviceListHomePage.clickOnTab("plans")
            deviceListHomePage.addItemToBasket(planId)
            deviceListHomePage.selectCcaPriceCombinationInBasketForFullCCA()
            deviceListHomePage.clickOnTab("extras")
            deviceListHomePage.addDataAllowanceItemToBasket(dataAllowanceId)
            deviceListHomePage.addItemToBasket(insuranceId)

            RegistrationPage registrationPage = deviceListHomePage.startCheckout()
            registrationPage.acceptAdvisorChecks()
            registrationPage.enterCreditCheckDetailsSection()

            PaymentPage paymentPage = registrationPage.clickPayByCard()
            paymentPage.enterSecurityNumber()
            OrderConfirmationPage orderConfirmationPage = paymentPage.clickOnPayNow()
            String orderNumber = orderConfirmationPage.verifyOrderSubmittedSuccessfully()
            println "${deviceId}, ${planId}, ${dataAllowanceId}, ${insuranceId}, ${orderNumber}"
        }finally {
            WebDriverUtils.closeWebDriver()
        }
    }
}
