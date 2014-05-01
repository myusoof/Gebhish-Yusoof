package ThreadExample

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/04/14
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
class ThreadOne extends Thread {
    public volatile int ab = 0
    @Override
    void run(){
        ab++
    }
}
