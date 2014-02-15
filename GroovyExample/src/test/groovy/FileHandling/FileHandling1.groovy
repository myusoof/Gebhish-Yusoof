package FileHandling

import groovy.io.FileType

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 19/11/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */

def pattern = ~/.*\.json/
new File("/home/yusoof/projects/o2/Ecom_Fakes/ecommFixtures/src/main/resources").eachFileRecurse(FileType.FILES){
    filename ->
        if(filename.name.matches(pattern)){
            filename.eachLine {
                if(it.contains("price")){
                    println filename.canonicalPath  + "----" + it
                }
            }
        }

}