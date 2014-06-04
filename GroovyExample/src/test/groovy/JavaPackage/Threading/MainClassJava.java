package JavaPackage.Threading;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 21/05/14
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
public class MainClassJava {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);
        t.setName("Current Thread");
        System.out.println(t);

        try{
            for(int i = 0; i < 10; i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
