import java.io.*

/**
 * Created by yusoof on 23/10/14.
 */
class RunTImeExample {
    public RunTImeExample(){

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java", "-jar","/home/yusoof/projects/o2/Gebhish-Yusoof/SeleniumExploration/src/main/resources/seleniumrc.jar");
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
    public static void main(String[] args) {
        new RunTImeExample()
    }
}
