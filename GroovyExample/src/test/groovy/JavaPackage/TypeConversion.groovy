package JavaPackage

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 03/04/14
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
class TypeConversion {
    int defaultVariable = 1
    private int privateVariable = 1
    public int publicVariable = 1
    protected int protectedVariable = 1
    public static void main(String[] args) {
        byte a = 50
        int aa = (int)a * 20000
        println a instanceof Byte
        println aa
        int[] abc = new int[12];
        int i =0
        for(int abc1 : abc){
            abc[i] = i
            i++
        }
        println abc.length
        int i2 = 0
        for(int avc : abc){
            println abc[i2]
            i2++
        }
    }
}
