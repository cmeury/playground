package ch.wurmlo.scala.test


abstract class Tree {
  type Environment = String => Int
  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r)  => eval(l, env) + env(r, env)
    case Var(n)     => env(n)
    case Const(v)   => v

  }
}
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree



object TreeTest {
  def main(args: Array[String]) {

  }
}