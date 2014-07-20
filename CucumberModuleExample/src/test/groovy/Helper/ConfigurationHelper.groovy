package Helper

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/07/14
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
class ConfigurationHelper {

    static Properties getConfiguration(){
        Properties properties = new Properties()
        properties.load(this.getClass().getResourceAsStream("/propertiesFolder/configuration.properties"))
        properties
    }
/*
    public static void main(String[] args) {
        Properties properties = new Properties()
        properties.load(new FileInputStream(new File('/home/yusoof/projects/Gebhish-Yusoof/CucumberModuleExample/src/test/resources/propertiesFolder/configuration.properties')))
//        properties.load(new FileInputStream(getClass().getResource("")))
        println properties.getProperty("name")

        InputStream ini = this.getClass().getResourceAsStream("/propertiesFolder/configuration.properties")

        properties.load(ini)
        println properties.getProperty("name")
    }
*/
}
