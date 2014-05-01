package InheritanceExample1

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
class TraditionalInheritance {
    public static void main(String[] args) {
        def employee = new Employee(address: "test", age: "28", salary: "23033", name:"yusoof")
        employee.describe()

        MopEmployee mopEmployee = new MopEmployee(name : "Yusoof", newProperty: "newPropertyValue")
        println mopEmployee.newProperty
    }
}
