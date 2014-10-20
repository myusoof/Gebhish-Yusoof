package EnumPackage

/**
 * Created by yusoof on 19/10/14.
 */
class CarsSet {

    public static void main(String[] args) {
        EnumSet enumSet = EnumSet.allOf(Cars.class)
        
        for(String e : enumSet){
            println e
        }

        enumSet.each {
            println it
        }
    }
}
