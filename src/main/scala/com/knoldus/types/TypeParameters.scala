package com.knoldus.types

import scala.util.Random

object TypeParameters extends App{

  def randomElement[A](x:Seq[A]):A = x(Random.nextInt(x.size))
  randomElement[Int](List(1,2,3))
  randomElement[String](List("1","2","3"))
  println(randomElement(List("1","2","3")))
  
  
  type Callback[T] = scala.Function1[T, T]
  val f = (z:Int)=>z+2
  val x:Callback[Int] = f
  
  println(x(9))
}