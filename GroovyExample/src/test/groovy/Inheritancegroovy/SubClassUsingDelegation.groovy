package Inheritancegroovy

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */
class SubClassUsingDelegation {
    private delegate = new BaseClass()
    def salary

    def getName() {
        return name
    }

    void setName(def name) {
        this.name = name
    }

    def getAge() {
        return age
    }

    void setAge(def age) {
        this.age = age
    }

    def getNationality() {
        return nationality
    }

    void setNationality(def nationality) {
        this.nationality = nationality
    }
}
