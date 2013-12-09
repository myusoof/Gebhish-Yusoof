package HandsetToDevice

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonBuilder
import org.json.JSONObject

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 18/11/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/11/13
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
class HandsetToDeviceConversion {
    static ObjectMapper objectMapper
    public static void main(String ...args) throws Exception{
        def p = ~/.*\.json/
        def handsetInputPath = new File("/home/ee/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/handsets")
        String deviceOutputPath =  "/home/ee/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/handsets-devices"
        String planOutputPath =  "/home/ee/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/tariff-plan"

        def tariffInputPath = new File("/home/ee/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/tariffs")
        def prepaySimInputPath = new File("/home/ee/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/prepaySims")
        new File(deviceOutputPath).mkdir()
        new File(planOutputPath).mkdir()

        handsetInputPath.eachFileMatch(p){
            handsetToDeviceConverter(it,new File("${deviceOutputPath}/${it.name}"))
        }

        tariffInputPath.eachFileMatch(p){
            tariffToPlanConverter(it, new File("${planOutputPath}/${it.name}"))
        }

        prepaySimInputPath.eachFileMatch(p){
            prepaySimToPlanConverter(it, new File("${planOutputPath}/${it.name}"))
        }

    }

    static handsetToDeviceConverter(File fileInput,File fileOutput ){

        fileOutput.createNewFile()
        objectMapper = new ObjectMapper();
        Map<String, Object> handsetJson = objectMapper.readValue(fileInput,new TypeReference<Map<String, Object>>() {});
        Map<String, Object> deviceJson = handsetToDevice(handsetJson)
        fileOutput.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deviceJson))
    }

    static exampleObjectToMapperConversion(File fileInput, File fileOutput){
        objectMapper = new ObjectMapper()
        Map<String, Object> mapper = objectMapper.readValue(fileInput, new TypeReference<Map<String, Object>>() {})

    }

    static tariffToPlanConverter(File fileInput,File fileOutput){
        fileOutput.createNewFile()
        objectMapper = new ObjectMapper();
        Map<String, Object> tariffJson = objectMapper.readValue(fileInput,new TypeReference<Map<String, Object>>() {});
        Map<String, Object> planJson = tariffToPlan(tariffJson)
        fileOutput.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(planJson))
    }

    static prepaySimToPlanConverter(File fileInput,File fileOutput){
        fileOutput.createNewFile()
        objectMapper = new ObjectMapper();
        Map<String, Object> prepaySimJson = objectMapper.readValue(fileInput,new TypeReference<Map<String, Object>>() {});
        Map<String, Object> planJson = prepaySimToPlan(prepaySimJson)
        fileOutput.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(planJson))
    }


    static Map handsetToDevice(Map handsetJson) {
        Map deviceJson = [
                *: handsetJson,
                stockInfo: [
                        stock: handsetJson.stock,
                        *: [stockMessage: handsetJson.stockMessage].findAll {it.value},
                        *: [stockExtendedMessage: handsetJson.stockExtendedMessage].findAll {it.value},
                ]
        ]
        deviceJson.remove("stock")
        deviceJson.remove("stockMessage")
        deviceJson.remove("stockExtendedMessage")
        deviceJson.remove("canonicalModel")
        deviceJson.remove("canonicalBrand")
        deviceJson.remove("recommendedAccessories")
        deviceJson.remove("visible")

        switch (handsetJson.phoneType) {
            case "Standard": deviceJson.subType = "StandardPhone"; break;
            case "SmartPhone": deviceJson.subType = "SmartPhone"; break;
            case "iPhone": deviceJson.subType = "iPhone"; break;
        }
        deviceJson.remove("phoneType")

        deviceJson.relationships  = []

        HandsetDataType handsetDataType = handsetJson.dataType
        deviceJson.relationships << [type: "dataallowance", id: handsetDataType.category]
        deviceJson.remove("dataType")

        if (handsetJson.insurance?.id) {
            deviceJson.relationships << [type: "insurance", id: handsetJson.insurance.id]
        }
        deviceJson.remove("insurance")

        handsetJson.eligibleTariffs.each {
            deviceJson.relationships << [type: "plan", id: it.id, prices: [[oneOff: it.price]]]
        }
        deviceJson.remove("eligibleTariffs")

        handsetJson.prepaySimDetails?.eligiblePrepaySims?.each {
            deviceJson.relationships << [type: "plan", id: it.id, prices: [[oneOff: handsetJson.prepaySimDetails.prepayPrice]]]
        }
        deviceJson.remove("prepaySimDetails")
        deviceJson["4gSupportedOnLaunch"] = false
        deviceJson["4gCapable"] = false
        deviceJson["4gEnabledBuildVersions"] = []

        deviceJson
    }

    static Map tariffToPlan(Map tariffJson) {
        Map planJson = [
                *: tariffJson,
                type: tariffJson.tariffType
        ]
        if (tariffJson.tariffType != "PreToPost") {
            planJson.family = tariffJson.tariffFamily
        }

        planJson.relationships  = []

        tariffJson.eligibleBillCredits.each {
            planJson.relationships << [type: "billcredit", id: it.id]
        }
        tariffJson.boltons.each {
            planJson.relationships << [type: "bolton", id: it.id]
        }
        planJson.remove("eligibleBillCredits")
        planJson.remove("tariffType")
        planJson.remove("paymentType")
        planJson.remove("category")
        planJson.remove("visible")
        planJson.remove("tariffFamily")
        planJson.remove("boltons")

        planJson
    }


    static Map prepaySimToPlan(Map prepaySimJson) {
        Map fulfillmentData = prepaySimJson.fulfillmentData
        Map planJson = [
                *: prepaySimJson,
                type: "Handset",
                productID: fulfillmentData.otherProducts[0].productId,
                extraInformation: prepaySimJson.description,
                fulfillmentData: [
                        productType: fulfillmentData.otherProducts[0].productType,
                        productName: fulfillmentData.otherProducts[0].productName,
                        otherProducts: [ [
                                productType: fulfillmentData.productType,
                                productId: prepaySimJson.sku.code,
                                productName: fulfillmentData.productName
                        ] ]
                ]
        ]
        planJson.remove("sku")
        planJson.remove("description")

        planJson
    }


    enum HandsetDataType {
        Standard("standard", "Standard phone"),
        SmartPhone("smartphone", "Smart Phone"),
        iPhone("iphone", "iPhone"),
        Blackberry("blackberry", "BlackBerry")

        final String category
        final String description

        HandsetDataType(String category, String description) {
            this.category = category
            this.description = description
        }
    }
}