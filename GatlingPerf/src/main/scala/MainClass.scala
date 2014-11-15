/**
 * Created by yusoof on 08/11/14.
 */
object MainClass {

  def main(args: Array[String]) {
    var listing : List[String] = List("apple", "orange", "pine", "time")
    listing.length
    for(xs <-0 to (listing.size -1)){
      println(listing(xs))
    }
    println(firstMethod())

  }

  def firstMethod() : Int ={
    return 1
  }
}
