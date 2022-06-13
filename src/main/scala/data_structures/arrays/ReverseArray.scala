package data_structures.arrays

import scala.reflect.ClassTag

object ReverseArray {

  // Common let's be honest this is how you'd really do it
  def reverse1[T](a: Array[T]): Array[T] = {
    a.reverse
  }

  // Classic "Java" style solution
  def reverse2[T : ClassTag](a: Array[T]): Array[T] = {
    val len = a.length
    val r = new Array[T](len)

    (0 until len).foreach{ i =>
      r(len - 1 - i) = a(i)
    }
    r
  }

  // In-place memory swap
  def reverse3[T](a: Array[T]): Array[T] = {
    var left = 0
    var right = a.length - 1

    while(right > left) {
      val tempL = a(left)
      val tempR = a(right)

      a(left) = tempR
      a(right) = tempL

      left += 1
      right -= 1
    }

    a
  }



}
