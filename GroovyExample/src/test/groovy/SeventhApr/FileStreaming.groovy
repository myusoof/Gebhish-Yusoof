package SeventhApr

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 07/04/14
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
class FileStreaming {
    public static void main(String[] args) {
        FileInputStream fin = null
        try {
           fin = new FileInputStream("/home/ee/projects/Gebhish-Yusoof/GroovyExample/src/test/groovy/SeventhApr/text.txt")
           int read1
           if((read1 = fin.read()) != -1){
                println read1
           }
        }catch(Exception e){
            println e
        }
    }
}
