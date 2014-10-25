class RunnableTest1 implements Runnable{

    public static void main(String[] args) {
        new Thread(new RunnableTest1()).start()
    }

    static firstRunnableMethod(){
        println "first runnnable method"
    }

    static secondRunnableMethod(){
        println "second runnnable method"
    }

    @Override
    void run() {
      firstRunnableMethod()
      secondRunnableMethod()
    }
}
