/*
object test {
  println("Welcome to the Scala worksheet")
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
  val bits = encode(t1)("ab".toList)
  decode(t1, bits)
  // assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
}
*/