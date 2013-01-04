package ch.wurmlo.scala.test

import com.sun.xml.internal.ws.policy.ComplexAssertion

class Complex(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary
  override def toString() =
    "" + re + (if (im<0) "" else "+") + im + "i"
}

object Test {
  def main(args: Array[String]) {
    val c1 = new Complex(1,5)
    println(c1.im)
    println(c1)

  }
}