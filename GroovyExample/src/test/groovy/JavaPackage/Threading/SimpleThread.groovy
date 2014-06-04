package JavaPackage.Threading

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 21/05/14
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
class SimpleThread extends Thread{
    String abc

    public SimpleThread(String abc){
        this.abc = abc
    }

    public void run(){
        for(int i = 0; i <10; i++){
            println super.getName() + " " + i  + abc + " " +super.getPriority()
        }
    }
}
