package InheritanceExample1

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
class Employee {
    def salary
    private delegate = new Person()

    def getAge() {
        return delegate.age
    }

    void setAge(def age) {
        delegate.age = age
    }

    def getName() {
        return delegate.name
    }

    void setName(def name) {
        delegate.name = name
    }

    def getAddress() {
        return delegate.address
    }

    void setAddress(def address) {
        delegate.address = address
    }

    void describe(){
        println "object name is ${name} with age as ${age} and address has ${address} and salary is ${salary}"
    }
}
