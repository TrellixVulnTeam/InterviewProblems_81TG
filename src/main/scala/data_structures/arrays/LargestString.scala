package data_structures.arrays

// Problem statement https://codingrecipies.blogspot.com/2020/09/

object LargestString extends App {

  def indexToString(i: Int): String = (i + 'a').toChar + ""

  def getLargestString(s: String, k: Int): String = {
    val charCounts = new Array[Int](26)

    for (c <- s.toCharArray) charCounts(c - 'a') += 1

    val largestString: StringBuilder = new StringBuilder("")
    var i = 25 // Start a Z and work down

    while ( i >= 0 ) {

      val limit = if(largestString.endsWith(indexToString(i))) k-1 else k

      //check if the next highest chars has no more than k
      if (charCounts(i) >= limit) {
        // Add k characters to the largestString, and reduce the count for `i` by k
        largestString ++= indexToString(i)  * limit
        charCounts(i) -= limit

        //Iterate until you find the next highest character with a non-zero count
        var j = i - 1
        while (charCounts(j) <= 0 && j > 0) j -= 1

        //Just add 1 of the next highest character (if you find one)
        if (charCounts(j) > 0 && j >= 0) {
          largestString ++= indexToString(j)
          charCounts(j) -= 1
        }
        else {
          i = -1 // ok we are done!
        }
      }
      else if (charCounts(i) > 0) {
        largestString ++= indexToString(i) * charCounts(i)
        charCounts(i) = 0 // No more chars here for i
      }
      else {
        i -= 1
      }
    }

    largestString.toString
  }

  println(getLargestString("bacc", 2)) //output : ccbca
  println(getLargestString("zzzazzb", 2)) //output : zzbzzaz
  println(getLargestString("zzzxazz", 2)) //output : zzxzzaz
  println(getLargestString("zzzzzzxxxzzaabbazza", 5)) //output : zzzzzxzzzzzxxbbaaaa
  println(getLargestString("azzxxx", 2))  //output: zzxxax
}
