package InheritanceExample1

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/07/14
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
class Greet {
    def name
    Greet(String who){
        name = who[0].toUpperCase() + who[1..-1]
    }

    def salute(){ println "Hello ${name}!"   }
    def x = new X()


}
