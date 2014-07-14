package JavaPackage.JavaIO

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/07/14
 * Time: 00:22
 * To change this template use File | Settings | File Templates.
 */
class BufferedInputStreamDemo {
    static String path = System.getProperty("user.dir")
    static String path1 = "${path}/GroovyExample/src/test/resources/JsonCreated.json"
    static File file = new File(path1)
    static InputStream inputStream = new FileInputStream(file)
    static OutputStream outputStream = new FileOutputStream(file)
    static BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)
    static BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)

    public static void main(String[] args) {

        int bufferInt = bufferedInputStream.available()
        byte[] byteArray = new byte[bufferInt]
//        bufferedInputStream.read(byteArray, 2,byteArray.length-10)

        for(byte b1: byteArray){
          // println ((char)b1)
        }
        bufferReset()
        writeFile()
    }

    static void bufferReset(){
        println ((char)bufferedInputStream.read())
        println ((char)bufferedInputStream.read())
        println ((char)bufferedInputStream.read())
        bufferedInputStream.skip(1)
        println "------------------"
        bufferedInputStream.mark(1)
        println ((char)bufferedInputStream.read())
        println ((char)bufferedInputStream.read())
        bufferedInputStream.reset()
        println "------------------"
        println ((char)bufferedInputStream.read())
        println ((char)bufferedInputStream.read())
        println ((char)bufferedInputStream.read())
    }

    static void writeFile(){

        bufferedOutputStream.write(bufferedInputStream.read())
    }
}
