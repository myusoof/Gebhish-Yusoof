/**
 * Created by yusoof on 19/10/14.
 */
class ShutDownHookExample {

    public static void main(String[] args) {
        println "testststest"
    }

    static{
        println "test"
    }


    static{
        println "static 2"
    }

    static{
        println Runtime.currentRuntime.freeMemory()/1024/1024
        println Runtime.currentRuntime.availableProcessors()
//        System.in.read()
//        System.exit(0)
        println Shutdown.state
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                println "shutdown hook"
            }
        })
        println Runtime.currentRuntime.totalMemory()/1024/1024

    }
}
