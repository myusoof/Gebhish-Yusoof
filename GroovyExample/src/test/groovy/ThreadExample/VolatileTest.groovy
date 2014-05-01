package ThreadExample

import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggerFactory


/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/04/14
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
class VolatileTest {
    private static synchronized int MY_INT = 0
    public static void main(String[] args) {
        new ChangeListener().start()
        new ChangeMaker().start()
    }

    static class ChangeListener extends Thread{
        @Override
        void run(){
            int LOCAL_VALUE = MY_INT
            while(LOCAL_VALUE < 5){
                if(LOCAL_VALUE !=MY_INT){
                    println MY_INT
                    LOCAL_VALUE = MY_INT
                }
            }

        }
    }

    static class ChangeMaker extends Thread{
        @Override
        void run(){
           int LOCAL_VALUE = MY_INT
            while (MY_INT < 5){
                MY_INT = ++LOCAL_VALUE
                try{
                    Thread.sleep(500)
                }   catch (Exception e){

                }
            }
        }
    }
}
