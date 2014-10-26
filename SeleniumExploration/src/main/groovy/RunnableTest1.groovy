class RunnableTest1 {
    public static void main(String[] args) {
        String serverPath = this.class.getResource("/selenium-server-standalone-2.39.0.jar").path

        ProcessBuilder process = new ProcessBuilder("java", "-jar", serverPath, "-port", "5000", "-role", "hub")
        List<Process> processList = new ArrayList<Process>()
        processList[0] = process.start()
        Thread.sleep(5000)
        processList[0].destroy()
    }

}
