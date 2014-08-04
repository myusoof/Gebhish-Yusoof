package JavaPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 25/07/14
 * Time: 09:17
 * To change this template use File | Settings | File Templates.
 */
public class Java8Trial {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/ee/projects/Gebhish-Yusoof/GroovyExample/src/test/resources/text111.properties"))));
        String line = reader.readLine();
        while(line !=null){
            System.out.println(line);
        }
    }
}
