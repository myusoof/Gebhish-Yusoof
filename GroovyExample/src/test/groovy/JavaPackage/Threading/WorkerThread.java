package JavaPackage.Threading;

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 21/05/14
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class WorkerThread implements Runnable{

    String command;
    public WorkerThread(String command){
      this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end");
    }

    void processCommand(){
        try{
        Thread.sleep(5000);}
        catch(Exception e){
            System.out.println("test1");
        }
    }
}
