package com.knoldus.collections

object ViewFun extends App {
  List(1, 2, 3, 4) map { i => println(i); i + 1 }
  val b = List(1, 2, 3, 4).view map { i => println(i); i + 1 }
  //b.toList
}