package InheritanceExample1

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/07/14
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */

def list1 = ['One', 'Two', 'Three']

println list1*.length()
println list1.collect {it -> it.length()}

def user = "yusoof"
println  user ?: null
println 1<=>2
println 2<=>2
println 3<=>2

def list2 = ["One", "two", "three", "four"]
println list2*.length()
println 1.is(1)

def closure1 = { number ->
    println number
}

def closureFunction(n){
    println n
}
def closureFunction1 = this.&closureFunction(1)
closure1.call(2)

def curryExp = {firstName, secondName -> println firstName + secondName}

println curryExp.curry("ttest")
