package InheritanceExample1

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
class MopEmployee {
    def delegate = new Person()
    def newProperty
    private boolean hasLocalProperty(name) {
        return metaClass.properties.collect{ it.name }.contains(name)
    }

    MopEmployee(Map map) {
        map.each{
            k, v -> setProperty(k, v)
        }
    }

    void setProperty(String name, value) {
        //println this.@"$name"
        if (hasLocalProperty(name))
        {
            this.@"$name" = value
        }
        else
        {
            delegate.setProperty(name, value)
        }
    }

}
