package Inheritancegroovy

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
class SubClassUsingMOP {
    private delegate = new BaseClass()
    private hasLocalProperty(name) {
        metaClass.properties.collect{ it.name }.contains(name)
    }
    def salary

    SubClassUsingMOP(Map map) {
        map.each{ k, v -> setProperty(k, v) }
    }
    void setProperty(String name, value) {
        if (hasLocalProperty(name)) this.@"$name" = value
        else delegate.setProperty(name, value)
    }
    def getProperty(String name) {
        if (hasLocalProperty(name)) return this.@"$name"
        else return delegate.getProperty(name)
    }
}
