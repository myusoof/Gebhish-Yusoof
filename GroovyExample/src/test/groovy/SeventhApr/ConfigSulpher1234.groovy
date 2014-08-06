package SeventhApr

import groovy.json.JsonSlurper
import groovy.util.slurpersupport.GPathResult

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/08/14
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
class ConfigSulpher1234 {
    public static void main(String[] args) {
        ConfigObject object1 = new ConfigSlurper().parse(this.class.getResource("/text111.properties"))
        println object1.xpath

        Object jsonObject = new JsonSlurper().parse(new InputStreamReader(this.class.getResourceAsStream("/JsonFile.json")))
        //println jsonObject.results.address_components.long_name
       //println this.class.getResourceAsStream("/xmlPraser.xml").text

        def xmlObject = new XmlSlurper().parseText(this.class.getResourceAsStream("/xmlPraser.xml").text)
        println xmlObject
    }
}
