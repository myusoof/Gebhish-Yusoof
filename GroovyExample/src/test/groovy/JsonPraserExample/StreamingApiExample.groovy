package JsonPraserExample

import com.fasterxml.jackson.core.JsonEncoding
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 12/07/14
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
class StreamingApiExample {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")
        String path1 = "${path}/GroovyExample/src/test/resources/JsonCreated.json"
        File file = new File(path1)
        file.createNewFile()
        JsonFactory jfactory = new JsonFactory();
        JsonGenerator jGenerator = jfactory.createJsonGenerator(file, JsonEncoding.UTF8);
        jGenerator.writeStartObject(); // {

        jGenerator.writeStringField("name", "mkyong"); // "name" : "mkyong"
        jGenerator.writeNumberField("age", 29); // "age" : 29

        jGenerator.writeFieldName("messages"); // "messages" :
        jGenerator.writeStartArray(); // [

        jGenerator.writeString("msg 1"); // "msg 1"
        jGenerator.writeString("msg 2"); // "msg 2"
        jGenerator.writeString("msg 3"); // "msg 3"
        jGenerator.writeEndArray(); // ]
        jGenerator.writeEndObject(); // }
        jGenerator.close();


        JsonParser jsonParser = jfactory.createJsonParser(file)

        while(jsonParser.nextToken() != JsonToken.END_OBJECT){
            println jsonParser.getText()
        }
    }

}
