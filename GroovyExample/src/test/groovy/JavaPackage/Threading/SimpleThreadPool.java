package JavaPackage.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 21/05/14
 * Time: 10:48
 * To change this template use File | Settings | File Templates.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            executor.execute(new WorkerThread("" + i));
        }
        executor.shutdown();
    }
}
