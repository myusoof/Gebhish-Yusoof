package JavaPackage

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/04/14
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
class SingleTonDemo {
    public static void main(String[] args) {
        Singleton1 singleton1 = new Singleton1()
        Singleton1 singletonClass = Singleton1.getInstance()
        Number number = new Integer(10)
        println number.parseInt("100")
        Date date = new Date()
        SimpleDateFormat format = new SimpleDateFormat("z")
        println format.format(date)
    }
}
