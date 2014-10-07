package recfun

object homework01 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def balance(chars: List[Char]): Boolean =
    	if (chars.isEmpty) true
    	else {
    		val right_brace = chars.indexOf(')')
    		val left_brace = chars.indexOf('(')
    		if (right_brace == -1 && left_brace == -1)
    		  true
    		  else if (right_brace == -1 || left_brace == -1)
    		    false
    		    else {
				    		val matched_left_brace = chars.lastIndexOfSlice("(".toList, right_brace)
				    		if (matched_left_brace == -1)
				    		  false
				    		  else {
				    		    val rest = chars.slice(0, matched_left_brace):::chars.slice(right_brace+1, chars.size+1)
				    		    balance(rest)
				    		  		}
    		    			}
    		}                                 //> balance: (chars: List[Char])Boolean
  
  balance("(if (zero? x) max (/ 1 x))".toList)    //> res0: Boolean = true
  balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)
                                                  //> res1: Boolean = true
  balance(":-)".toList)                           //> res2: Boolean = false
  balance("())(".toList)                          //> res3: Boolean = false
}