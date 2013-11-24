package Migration

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonBuilder
import org.json.JSONObject


/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/11/13
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
class HandsetToDeviceConversion {
    static ObjectMapper objectMapper
    public static void main(String ...args){
        def p = ~/.*\.json/
        def fileInput = new File("/home/yusoof/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/handsets")

        fileInput.eachFileMatch(p){
            String outputPath =  "/home/yusoof/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources/handsets-devices"
            handsetToDeviceConverter(it,new File("${outputPath}/${it.name}"))
        }
    }

    static handsetToDeviceConverter(File fileInput,File fileOutput ){
        objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(fileInput,new TypeReference<Map<String, Object>>() {});
        fileOutput.createNewFile()
        def device = new Device(id: map.id)
        def jsonBuilder = new JsonBuilder()
        jsonBuilder(device)
        println jsonBuilder.toPrettyString()
        fileOutput.write(jsonBuilder.toPrettyString())
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
