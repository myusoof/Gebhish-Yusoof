package JavaPackage.Threading

import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 21/05/14
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
class RejectedExecutionHandleIMpl implements RejectedExecutionHandler {
    @Override
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }
}
