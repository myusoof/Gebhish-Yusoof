/**
 * Created by yusoof on 06/09/14.
 */
class ProcessBuilderExample {
    public static void main(String[] args) {
        def list1 = ['a': "one", "b": "two"]
        def list2 = list1.collect {it.key}
        println list2
        list1 = list1.plus(['c': "three"])
        println list1.entrySet().value
        /*ProcessBuilder processBuilder = new ProcessBuilder(['java', 'version'])
        Process process = processBuilder.start()
        println process.inputStream.read()*/

    }
}