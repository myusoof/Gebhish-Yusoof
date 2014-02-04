package FileHandling

import sun.misc.BASE64Encoder
import sun.misc.resources.Messages_de

import java.nio.charset.Charset
import java.security.MessageDigest

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 25/01/14
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
class StringHandling2 {
    public static void main(String[] args) {
        String test = "yusoof"
        MessageDigest md = MessageDigest.getInstance("MD5")
        md.update(test.getBytes())
        byte[] bytes = md.digest()
        byte[] bytes1 = test.getBytes()
        println bytes
        println bytes1
        BASE64Encoder encoder = new BASE64Encoder();
        println encoder.encode(bytes)
        StringBuilder sb = new StringBuilder()
        for(byte byt : bytes){
            sb.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        println sb
    }
}
