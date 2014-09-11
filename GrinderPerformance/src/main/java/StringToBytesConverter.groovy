import ch.qos.logback.core.encoder.ByteArrayUtil
import groovyjarjarantlr.StringUtils

/**
 * Created by yusoof on 10/09/14.
 */
class StringToBytesConverter {
    public static void main(String[] args) {
        String abc = "This is the string to convert into bytes"
        println abc.bytes
        StringBuilder builder = new StringBuilder()
        for(byte byte1 : abc.bytes){
            builder.append((char) byte1)
        }
        println builder
    }
}
