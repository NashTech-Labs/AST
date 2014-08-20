package com.knoldus
import scala.collection.mutable

class Starter {
  val l: mutable.Map[Int, Int] = mutable.Map.empty
  var li: Map[Int, Int] = Map.empty

  def insertAndGetValuesFromMutableMap(n: Int) = {
    (1 to n) map (x => l += ((x -> x)))
    println(s"Size of the Mutable Map = ${l.size}")
    (1 to n) map (z => l(z))
  }

  def insertAndGetValuesFromImmutableMap(n: Int) = {
    (1 to n) map (x => li += ((x -> x)))
    println(s"Size of the Immutable Map = ${li.size}")
    (1 to n) map (z => li(z))
  }

  import scala.annotation.switch
  import scala.annotation.tailrec

  def otimised3(x: Int) =
    (x: @switch) match {
      case 1 => "One"
      case 2 => "Two!"
      case i: Int => "Other"
    }

}

object Starter extends App {
  val NUMBER_OF_KEYS = 5000000
  val start = System.currentTimeMillis()
  (new Starter).insertAndGetValuesFromMutableMap(NUMBER_OF_KEYS)
  val end = System.currentTimeMillis()
  println(s"Time taken in mutable map = ${end - start}")

  val start1 = System.currentTimeMillis()
  (new Starter).insertAndGetValuesFromImmutableMap(NUMBER_OF_KEYS)
  val end1 = System.currentTimeMillis()
  println(s"Time taken in immutable map = ${end1 - start1}")

}