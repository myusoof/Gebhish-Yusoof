package JavaPackage

import sun.nio.cs.ext.IBM1006

import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

import static java.nio.charset.Charset.*

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/04/14
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
class ConfigHelper1 {
    public static void main(String[] args) {
        File file = new File("./GroovyExample/src/test/resources/text111.properties")
        println file.path
        println file.getCanonicalPath()
        println file.toURI()

        String abc = ConfigHelper1.class.getResourceAsStream("/resources/text111.properties")
        println abc
        byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
        println encoded
        Charset encoding = new IBM1006()
        println encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
