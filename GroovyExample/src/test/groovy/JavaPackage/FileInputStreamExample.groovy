package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 07/04/14
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
class FileInputStreamExample {
    public static void main(String[] args) {
        File file = new File("./GroovyExample/src/test/resources/text111.properties")
        println file.path
        println file.getCanonicalPath()
        println file.toURI()

        println FileInputStreamExample.class.getResource("/resources")

        String abc = ConfigHelper1.class.getResourceAsStream("/resources/text111.properties")
        println abc
//        FileInputStream fin = new FileInputStream(new File())
//        println fin.read()
    }
}
