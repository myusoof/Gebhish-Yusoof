/**
 * Created by yusoof on 06/09/14.
 */
class ProcessBuilderExample {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(['java', 'version'])
        Process process = processBuilder.start()
        println process.inputStream.read()

    }
}
