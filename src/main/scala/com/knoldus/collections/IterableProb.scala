package com.knoldus.collections

object IterableProb extends App {
  val x = collection.mutable.ArrayBuffer(1, 2, 3)
  val i = x.iterator
  x.remove(0, 3)
  i.hasNext
  i.next

}