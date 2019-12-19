package solutions

object ScalaSolution003 {

  sealed trait Tree
  case object Leaf extends Tree
  case class Node(value: String, left: Tree, right: Tree) extends Tree

  def serialize(root:Tree): String = {
    def helper(n: Tree, acc: String): String = n match {
      case Leaf => acc + "# "
      case Node(v, l, r) =>
        val newAcc = helper(l, acc + s"$v ")
        helper(r, newAcc)
    }
    helper(root, "").trim
  }

  def deserialize(serialized:String): Tree = {
    helper(serialized.split(' ').toList)

    def helper(s: List[String]): Tree = {
      //println(s"DEBUG: ${s.mkString(" ")}")
      s match {
        case List("#") => Leaf
        case n :: ns =>
          val left = helper(ns)

      }
    }


  }

  def main(args: Array[String]): Unit = {
    val t1 = Node("a", Node("b", Leaf, Leaf), Node("c", Node("d", Leaf, Leaf), Leaf))
    val t1Result = deserialize(serialize(t1))
    println(s"testTree1 serialized is: ${serialize(t1)}")
    println(s"Result1 serialized is  : ${serialize(t1Result)}")

    val t2 = Node("a", Node("b", Node("c", Leaf, Leaf), Leaf), Node("d", Leaf, Leaf))
    val t2Result = deserialize(serialize(t2))
    println(s"testTree2 serialized is: ${serialize(t2)}")
    println(s"Result2 serialized is  : ${serialize(t2Result)}")

  }

}
