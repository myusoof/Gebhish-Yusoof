import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 30/08/14
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
public class FirstTestInterview {

    public static void main(String[] args) {
        int a = maxConsecutiveValue("yusf");
        System.out.println(a);
    }

    static Integer maxConsecutiveValue(String stringValue) {
        List<Integer> maxvalue = new ArrayList<Integer>();
        int returnValue = 1;
        if(stringValue.length() < 1){
            returnValue = 0;
            return returnValue;
        }
        for (int i = 0, j = 0; i < stringValue.length(); i++) {
            j = i + 1;
                if(j <= stringValue.length()){
                    if(stringValue.charAt(i) == stringValue.charAt(j)){
                        returnValue++;
                    }else{
                        maxvalue.add(returnValue);
                        returnValue = 1;
                    }
                }else{
                    maxvalue.add(returnValue);
                }

        }
        returnValue = Collections.max(maxvalue);
        return returnValue;
    }
}
