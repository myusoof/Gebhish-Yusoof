package FactoryPattern

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
class FactoryClassDemo {
    public static void main(String[] args) {
        PersonFactoryClass personFactoryClass = new PersonFactoryClass("female")
        println personFactoryClass.getInstance().gender
    }
}
