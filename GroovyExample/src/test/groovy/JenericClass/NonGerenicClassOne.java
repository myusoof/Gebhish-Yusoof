package JenericClass;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ee on 28/08/14.
 */
public class NonGerenicClassOne {
    String a;
    String b;

    public NonGerenicClassOne(String a, String b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
       NonGerenicClassOne nonGerenicClassOne = new NonGerenicClassOne("One", "two");

        System.out.println(nonGerenicClassOne.a);
        List a = new LinkedList<String>();
        Collections.synchronizedList(a);
        a.add(0, "testt");
        a.add(1, "test2");

        System.out.println(a.size());
        System.out.println(a.iterator().next());
        System.out.println(a.iterator().hasNext()   );
    }
}
