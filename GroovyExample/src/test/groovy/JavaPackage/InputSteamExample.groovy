package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 06/04/14
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
class InputSteamExample {
    public static void main(String[] args){

        try{
            byte[] bWrite = [11,21,3,40,5];
            OutputStream os = new FileOutputStream("test1.txt");
            for(int x=0; x < bWrite.length ; x++){
                os.write( bWrite[x] ); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test1.txt");
            int size = is.available();

            for(int i=0; i< size; i++){
                System.out.print((char)is.read() + "  ");
            }
            is.close();
        }catch(IOException e){
            System.out.print("Exception");
        }
    }}
