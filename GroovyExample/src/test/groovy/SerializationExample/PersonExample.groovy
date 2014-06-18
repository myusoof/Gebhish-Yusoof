package SerializationExample

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 11/06/14
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
class PersonExample implements Serializable {
    String firstName
    String lastName
    int age

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        this.age = age
    }
}
