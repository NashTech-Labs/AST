package com.knoldus.collections

object MapFun extends App {
  val errorcodes = Map(1 -> "O NOES", 2 -> "KTHXBAI", 3 -> "ZOMG")
  val g = List(1, 3) map errorcodes
  println(g)

  val addresses = Map("josh" -> "123 someplace dr").withDefaultValue("245 TheCompany St")
  println(addresses("josh"))
  println(addresses("john"))

}