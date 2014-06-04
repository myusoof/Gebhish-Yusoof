package JavaPackage.Threading

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 21/05/14
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
class NewThread implements Runnable{

    Thread t
    public NewThread(){
        t = new Thread(this, "Demo Thread")
        println "this is the new thread"
        t.start()
    }


    @Override
    void run() {
        try{
        for(int i = 0; i < 5; i++){
            println "Child tread ${i}"
            Thread.sleep(5000)
        }
        }catch(InterruptedException e){

        }
    }
}
