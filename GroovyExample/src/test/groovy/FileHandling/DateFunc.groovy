package FileHandling

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/02/14
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
def time1 = new Date().time - 1000*60*60*24
println new Date(time: time1)
def re= "abc".replaceAll(/(a)(b)(c)/, "${1}${3}")
println(re)
