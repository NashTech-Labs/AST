package com.knoldus.collections

import scala.collection.immutable.LinearSeq

object SeqFun extends App {
  val x = Seq(2, 1, 30, -2, 20, 1, 2, 0)
  val h = (x.tails map (_.take(2)) filter (_.length > 1) map (_.sum) toList)
  println(h)
  
  println(Seq(2,1,30,-2,20,1,2,0).sliding(2).map(_.sum).toList)
  
  
  val xl = LinearSeq(1, 2, 3)
  println(xl.head)
  val xi = IndexedSeq(1, 2, 3)
  println(xi(2))
}