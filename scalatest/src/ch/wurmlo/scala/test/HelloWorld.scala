package ch.wurmlo.scala.test

import java.util.Date
import java.text.DateFormat._

object HelloWorld {
  def main(args: Array[String]) {
    val now = new Date()
    val df = getDateInstance()
    println(df format now)
  }
}
