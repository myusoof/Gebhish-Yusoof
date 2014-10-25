package javapackageexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yusoof on 21/10/14.
 */
public class CollectionExample {
    public static void main(String[] args) {
        ArrayList collection = new ArrayList();
        System.out.println(collection.size());
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(1);
//        collection.set(2,1);
        collection.lastIndexOf(1);
        Set set1 = new HashSet(collection);
        System.out.println(set1.size());
    }
}
