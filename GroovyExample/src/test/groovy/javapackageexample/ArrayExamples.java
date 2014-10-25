package javapackageexample;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yusoof on 20/10/14.
 */
public class ArrayExamples {
    public static void main(String[] args) {
        String[] abc = new String[10];
        for(int i =0; i <10; i++){
            abc[i] = "string";
        }
        for(int i =0; i <=abc.length -1; i++){
            System.out.println(abc[i]);
        }
        int[] intAbc = {1,2,3,4,5};

        List list = Arrays.asList("String1");

        System.out.println(list);
        int[] abv = new int[10];
        Arrays.fill(abv,1);
        System.out.println(abv[9]);

    }
}
