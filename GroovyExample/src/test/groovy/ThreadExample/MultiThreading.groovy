package ThreadExample

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 21/04/14
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
class MultiThreading {

    public static void main(String[] args) {

        DispThread d1 = new DispThread("Hello")
        DispThread d2 = new DispThread("World")
        Thread t1 = new Thread(d1)
        Thread t2 = new Thread(d2)
        t1.start()
        print " "
        t2.start()
    }


    static class DispThread extends Thread{

        String message
        public DispThread(String message){
            this.message = message
        }
        @Override
        public void run(){
            print message
        }

    }
}
