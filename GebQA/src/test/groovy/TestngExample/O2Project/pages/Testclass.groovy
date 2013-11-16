package TestngExample.O2Project.pages

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/11/13
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */

/*println "Thilip"
def string1 ="Thlip "
string1 = new String("trdt")
def list1 = [1,2,3,4]
def map1 = [1:"One",2:"Two", 3:"Three"]
println map1.get(1)
println list1 instanceof List<Integer>
println string1*/


def firstMethod = {  String one ->
    println one

}
firstMethod  "Ulag"

def list1 = [1,2,3,4]

list1.each {
    println it
}