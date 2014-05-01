package ThreadExample

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/04/14
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
class ThreadOneDemo {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            ThreadOne threadOne = new ThreadOne()
            threadOne.start()
            println threadOne.ab
        }
    }
}
