package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 04/04/14
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
class Box extends Object{
    double width
    double length
    double height
    int tos

    public Box(width, length, height){
        this.width = width
        this.length = length
        this.height = height
        tos = -1
    }
    public Box(){
        tos = -2
    }

    void volume(){
        println width * height * length
    }
    @Override
    protected void finalize() throws Throwable{
        println "testing"
        super.finalize()
    }

    @Override
    public void run(){
        volume()
    }
}
