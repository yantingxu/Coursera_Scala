package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    		}
    // balance("(if (zero? x) max (/ 1 x))".toList)
    // print(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    // print(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
		  if (c == r || c == 0) 1
		  else pascal(c, r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = 
    	if (chars.isEmpty) true
    	else {
    		val right_brace = chars.indexOf(')')
    		val left_brace = chars.indexOf('(')
    		if (right_brace == -1 && left_brace == -1) true
    		else if (right_brace == -1 || left_brace == -1) false
    		else {
				    		val matched_left_brace = chars.lastIndexOfSlice("(".toList, right_brace)
				    		if (matched_left_brace == -1) false
				    		else {
				    		    val rest = chars.slice(0, matched_left_brace):::chars.slice(right_brace+1, chars.size+1)
				    		    balance(rest)
				    		  	}
    		    }
    		}

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 
    if (money < 0) 0
    else if (money == 0) 1
    else if (coins.isEmpty) 0
    else coins.indices.toList.foldLeft(0)((m: Int, n: Int) => m + countChange(money-coins.apply(n), coins.slice(n, coins.size+1)))
}
