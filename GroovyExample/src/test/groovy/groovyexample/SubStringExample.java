package groovyexample;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 30/08/14
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class SubStringExample {
    public static void main(String[] args) {
        String stringValue = "The main string";
        System.out.println(stringValue.substring(5,stringValue.length()));
        String stringValue1 = "1";
        Integer i = 1;
        i.toString();
        Integer.toString(1);
        System.out.println(Integer.decode(stringValue1));
        System.out.println(Integer.valueOf("100", 16)) ;

        for(int j =0 ; j <10; j++){
            double a = Math.random()*100;
            System.out.println(new Double(a).intValue());
        }

        System.out.println(Integer.toString(65, 16));
        System.out.println(Integer.valueOf("230", 5));
        Double.isNaN(10.000f);
    }
}
