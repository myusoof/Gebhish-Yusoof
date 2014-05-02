package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/04/14
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
class Singleton1 {
    private static Singleton1 instance = null

    private static String a
    protected Singleton1(){
    }

    static Singleton1 getInstance(){
        if(instance == null){
            a = "first run"
            println a
            instance = new Singleton1()
        }
        return instance
    }
}
