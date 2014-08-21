package com.knoldus.collections

object IteratorFun extends App {
  val names = Iterable("Josh", "Jim")
  val address = Iterable("123 Anyroad, Anytown St 11111", "125 Anyroad, Anytown St 11111")
  val address1 = Iterable("123 Anyroad, Anytown St 11111", "125 Anyroad, Anytown St 11111")
  val n = names.iterator
  val a = address.iterator
  val b = address1.iterator
  while (n.hasNext && a.hasNext && b.hasNext) {
    println(n.next + " lives at " + a.next + b.next)
  }

}