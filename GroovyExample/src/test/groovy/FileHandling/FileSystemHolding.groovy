package FileHandling

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 23/05/14
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
class FileSystemHolding {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("FileHandling.test", Locale.ENGLISH)
        ResourceBundle bundle_us = ResourceBundle.getBundle("FileHandling.test", Locale.KOREA)
        println bundle.getString("key1")
        println bundle.getString("key2")
        println bundle_us.getString("key1")
        println bundle_us.getString("key2")
    }
}
