/**
 * Created by yusoof on 08/11/14.
 */
class Point(var px: Int, var py:Int) {

    def move(x: Int, y: Int) {
    px += x
    py += y
    return Pair(px, py)
  }

}

object test1111{
  def main(args: Array[String]) {
    var point: Point = new Point(0,0)
    point.move(10,10)
    println(point.px)
    println(point.py)
  }
}
