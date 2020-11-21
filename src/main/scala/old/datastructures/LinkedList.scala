package old.realquestions.datastructures

trait LinkedList {
  def head():Int
  def tail(): LinkedList
  def +: (n:Int): LinkedList
  def ++: (l:LinkedList): LinkedList
}

case object EmptyList extends LinkedList
{
  def head(): Int = throw new Exception("Head on empty list")
  def tail(): LinkedList = throw new Exception("Tail on empty list")

  def +: (n: Int): LinkedList = Node(n, EmptyList)
  def ++: (l: LinkedList): LinkedList = l
  override def toString: String = ""
}

case class Node(h:Int, t:LinkedList) extends LinkedList {
  def head(): Int = h
  def tail(): LinkedList = t
  def +:(n: Int): LinkedList = Node(n, this)
  def ++: (l: LinkedList): LinkedList = l match {
    case EmptyList => this
    case Node(hl, tl) => hl +: (tl ++: this)
  }

  override def toString: String = {
    @scala.annotation.tailrec
    def helper(l: LinkedList, acc: String): String = l match {
      case EmptyList => acc
      case Node(x, l2) => {
        val newAcc = if(acc.length > 1)  s"$acc, $x"  else s"$acc $x"
        helper(l2, newAcc)
      }
    }

    s"[${helper(this, "")}]"
  }

}