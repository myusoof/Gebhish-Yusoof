package groovy
/**
 * Created by yusoof on 06/09/14.
 */
class ProcessBuilderExample extends Thread{

    @Override
    public void run() {
        def list1 = ['a': "one", "b": "two"]
        def list2 = list1.collect {it.key}
        println list2
        list1 = list1.plus(['c': "three"])
        println list1.entrySet().value
        ProcessBuilder processBuilder =  new ProcessBuilder("java", "-jar","/home/yusoof/projects/o2/Gebhish-Yusoof/SeleniumExploration/src/main/resources/seleniumrc.jar")
        Process process = processBuilder.start()
        process.inputStream.eachLine {println it}
        println "test"

    }

/*    public static void main(String[] args) {
        def list1 = ['a': "one", "b": "two"]
        def list2 = list1.collect {it.key}
        println list2
        list1 = list1.plus(['c': "three"])
        println list1.entrySet().value
        ProcessBuilder processBuilder =  new ProcessBuilder("java", "-jar","/home/yusoof/projects/o2/Gebhish-Yusoof/SeleniumExploration/src/main/resources/seleniumrc.jar")
        Process process = processBuilder.start()
        process.inputStream.eachLine {println it}
        println "test"
    }*/
}