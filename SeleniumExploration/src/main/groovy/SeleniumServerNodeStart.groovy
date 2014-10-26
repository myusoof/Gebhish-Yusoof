class SeleniumServerNodeStart implements Runnable{
    static List<Process> processList = new ArrayList<Process>()
    String port
    String role

    public SeleniumServerNodeStart(String port, String role){
        this.role = role
        this.port = port
    }


    @Override
    void run() {
         startSeleniumServerAndNode(role, port)
    }
    static List<Process> startSeleniumServerAndNode(String role, String port){
        ProcessBuilder processBuilder = null
        if(role.equals("hub")){
            processBuilder = new ProcessBuilder("java", "-jar", this.class.getResource("/selenium-server-standalone-2.39.0.jar").path, "-port", port, "-role", role)
            processList.add(processBuilder.start())
            println processList.size()
            Thread.sleep(5000)
        }else{
            //processBuilder = new ProcessBuilder("java", "-jar", this.class.getResource("/selenium-server-standalone-2.39.0.jar").path, "-port", port, "-role", role, "-nodeConfig", this.class.getResource("/testingconfig.json").file)
            processBuilder = new ProcessBuilder("java", "-jar", this.class.getResource("/selenium-server-standalone-2.39.0.jar").path, "-port", port, "-role", role )
            processList.add(processBuilder.start())
            println processList.size()
            Thread.sleep(5000)
        }
        processList
    }

//    static List<Process> startSeleniumNode(String role, String port){
//        ProcessBuilder processBuilder =
//                new ProcessBuilder("java", "-jar", this.class.getResource("/selenium-server-standalone-2.39.0.jar").path, "-port", port, "-role", role)
//        processList.add(processBuilder.start())
//        println processList.size()
//        Thread.sleep(5000)
//        processList
//    }

    public static void main(String[] args) {
        println processList.size()
        Thread thread1 = new Thread(new SeleniumServerNodeStart("5000", "hub"), "selenium server start")
        Thread thread2 = new Thread(new SeleniumServerNodeStart("5555", "node"), "selenium node start")
        thread1.start()
        thread2.start()

    }

}