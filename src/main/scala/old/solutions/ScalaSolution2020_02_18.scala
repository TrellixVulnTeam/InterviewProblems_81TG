package solutions

import scala.annotation.tailrec

/*
Given a linked list and a positive integer k, rotate the list to the right by k places.

For example, given the linked
list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7`

Given the linked
list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, it should become 4 -> 5 -> 1 -> 2 -> 3`
 */



//Definition for singly-linked list.

// Classic recursive solution!

trait LinkedList {
  def head: Int
  def tail: LinkedList
  def +: (e: Int): LinkedList
  def append(e: Int): LinkedList
  def rotateRight(n: Int): LinkedList
}

case object EmptyList extends LinkedList {
  def head: Int = throw new Exception("Calling head on Empty List")
  def tail: LinkedList = throw  new Exception("Calling tail on Empty List")

  def +: (e: Int): LinkedList = ListNode(e, EmptyList)
  def append(e: Int): LinkedList = ListNode(e, EmptyList)

  def rotateRight(n: Int): LinkedList = EmptyList
}

case class ListNode(h: Int, t: LinkedList) extends LinkedList {
  def head: Int = h
  def tail: LinkedList = t

  def +:(e: Int): LinkedList = ListNode(e, this)
  def append(e: Int): LinkedList = head +: tail.append(e)


  def rotateRight(n: Int): LinkedList =  n match {
      case i if i <= 0 => this
      case j => tail.append(head).rotateRight(n-1)
    }
}

object ScalaSolution2020_02_18 extends  App {

  val test1 = 7 +: 7 +: 3 +: 5 +: EmptyList
  val test2 = 1 +: 2 +: 3 +: 4 +: 5 +: EmptyList


  println("test1: " + test1)
  println("test1.rotate(2): " + test1.rotateRight(2))
  println("test2: " + test2)
  println("test2.rotate(3): " + test2.rotateRight(3))

}

  object ScalaSolution2 extends  App {

    // Say we have this (gross) definition for singly-linked list.
    class ListNode(var _x: Int = 0) {
      var next: ListNode = null
      var x: Int = _x
    }

    def displayList(head: ListNode): Unit = {
      @scala.annotation.tailrec
      def displayHelper(l:ListNode, acc: String): String = if(l.next == null)
        s"$acc, ${l.x}"
      else
        if(acc.length > 0)
        displayHelper(l.next, s"$acc, ${l.x}")
        else
        displayHelper(l.next, s"${l.x}")

      println(s"[${displayHelper(head, "")}]")
    }

    def createList(data: Seq[Int]): ListNode = {

      val head = new ListNode(data.head)
      var current = head
      data.tail.foreach{ d =>
        val nextNode = new ListNode(d)
        current.next = nextNode
        current = nextNode
      }
      head
    }

    def findLength(head: ListNode): Int = {

      @scala.annotation.tailrec
      def lengthHelper(current: ListNode, acc: Int): Int =
        if (current.next == null)
          acc
        else lengthHelper(current.next, acc+1)

      if(head == null)
        0
      else lengthHelper(head, 1)
    }

    def rotateRight(head: ListNode, k: Int): ListNode = {
      val length = findLength(head)
      val places = k % length  // no point in going longer than the length of the list!
      val start = head

      @scala.annotation.tailrec
      def moveAhead(c:ListNode, n:Int):ListNode = if(n == 0) c else moveAhead(c.next, n-1)
      val newStart = moveAhead(head, places)
      val newEnd = moveAhead(newStart, length-places-1)
      val terminateOldStart = moveAhead(start, places-1)
      terminateOldStart.next = null
      newEnd.next = start
      newStart

    }

    val test1 = createList( Seq(7,7,3,5))
    displayList(test1)
    val test1Rotated = rotateRight(test1, 2)
    displayList(test1Rotated)

    val test2 = createList( Seq(1,2,3,4,5))
    displayList(test2)
    val test2Rotated = rotateRight(test2, 3)
    displayList(test2Rotated)
  }
