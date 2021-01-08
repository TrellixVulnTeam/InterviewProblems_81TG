package data_structures.arrays

object Problem01_06 extends App {

  def rotationCipher(input: String, rotationFactor: Int): String = {

    def checker(c: Char, start: Char, size: Int): Boolean = {
      val diff = c - start
      diff >= 0 && diff < size
    }

    def isLowerCaseLetter(c: Char): Boolean = checker(c, 'a', 26)
    def isUpperCaseLetter(c: Char): Boolean = checker(c, 'A', 26)
    def isNumber(c: Char): Boolean = checker(c, '0', 10)

    def rotator(n: Char, start: Char, size: Int): Char = {
      val r = rotationFactor % size
      (((n - start + r) % size) + start).toChar
    }

    def rotateLowerCaseLetter(c: Char): Char = rotator(c, 'a', 26)
    def rotateUpperCaseLetter(c: Char): Char = rotator(c, 'A', 26)
    def rotateNumber(n: Char): Char = rotator(n, '0', 10)


    val result = input.map(c => c match {
        case a if isLowerCaseLetter(a) => rotateLowerCaseLetter(a)
        case a if isUpperCaseLetter(a) => rotateUpperCaseLetter(a)
        case n if isNumber(n) => rotateNumber(n)
        case _ => c
      }
    )

    result
  }

  val stdin = scala.io.StdIn
  val n: Int = stdin.readLine.trim.toInt
  val input: String = stdin.readLine

  val rotatedString = rotationCipher(input, n)

  println(s"""Input string: "$input" rotated string: "$rotatedString"""")

}
