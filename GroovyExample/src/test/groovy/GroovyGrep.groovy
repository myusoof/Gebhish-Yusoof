/**
 * Created by ee on 20/08/14.
 */



File file = new File("/home/ee/projects/o2/productCatalogueData_nda/catalogueData/device")
def ids = []
def matcher
file.eachFileRecurse {
            def abc
           if(it.name.endsWith("json") && it.name.toLowerCase().contains("iphone4s") && !it.name.contains("refurb")) {
               def regExpPattern = ~/"id"(\s|\S)?:(\s|\S)?"(.*)",/
               matcher = it.text =~ regExpPattern
               print it.name + "     "
               abc =  matcher[0][3]
               println abc
           }

                if(abc != null)  {
                    ids.add(abc)
                }
           }

    ids.each {
        println it
    }