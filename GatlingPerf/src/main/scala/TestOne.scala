/**
 * Created by yusoof on 08/11/14.
 */
object TestOne {

  def testOne(): Unit ={
    println("testsOneteststssetsettsergtsetsegtse")
    var (testOne1: Int, test1: String) = Pair(40,"rwrwrw")
    println(testOne1)
    println(test1)
  }

  var multiplier = (string : String) => {
    println(string)
  }

  var matrix = Array.ofDim[Int](3,3)

  def main(args: Array[String]) {
    testOne()
    multiplier("multiplier string")
  }
}
