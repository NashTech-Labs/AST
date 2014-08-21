package com.knoldus.collections

object StreamFun extends App {
  List("a", "b", "c") zip (Stream from 1)
  val s = 1 #:: {
    println("HI")
    2
  } #:: {
    println("BAI")
    3
  } #:: Stream.empty

  println(s(0), s(1), s(2))
  println(s)

  val fibs = {
    def f(a: Int, b: Int): Stream[Int] = a #:: f(b, a + b)
    f(0, 1)
  }

  println(fibs)
  
  fibs drop 3 take 5 toList
  
  println(fibs)
  
  
}