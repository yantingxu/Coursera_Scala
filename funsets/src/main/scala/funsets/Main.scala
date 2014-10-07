package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  def s(x: Int) = x >= 0 && x <= 10
  def f(x: Int) = 2*x
  printSet(map(s, f))
}
