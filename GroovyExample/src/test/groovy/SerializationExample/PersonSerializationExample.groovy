package SerializationExample

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 11/06/14
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
class PersonSerializationExample {

    public static void main(String[] args) {
        String filename = "test.ser"
        PersonExample p = new PersonExample(firstName: "Mohmed Yusoof", lastName: "Azeez Subhan", age: 29)
        FileOutputStream fos = null
        ObjectOutputStream oos = null

        try{
            fos = new FileOutputStream(filename)
            oos = new ObjectOutputStream(fos)
            oos.writeObject(p)
            oos.writeBoolean(true)
            oos.close()
        }   catch(Exception e){

        }

        FileInputStream fis = null
        ObjectInputStream ois = null

        try{
            fis = new FileInputStream(filename)
            ois = new ObjectInputStream(fis)
            PersonExample p1 = (Object)ois.readObject()
            ois.close()
            println p1.firstName
            println p1.lastName
            println p1.age
        }   catch(Exception e1){

        }
    }
}

