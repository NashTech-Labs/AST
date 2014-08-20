package com.knoldus.types

class A {
  type B >: scala.collection.immutable.List[Int]
  def foo(a: B) = a
}

class A1 {
  type B <: Traversable[Int]
  def count(b: B) = b.foldLeft(0)(_ + _)
}

// Lower and Upper Bound restrictions
object Restrictions extends App {
  val x = new A { type B = Traversable[Int] }
  val y = new A { type B = scala.collection.immutable.List[Int] }
  x.foo(Set(1, 2, 3))
  
  //Upper
  val x1 = new A1 {type B = scala.collection.immutable.List[Int]}
  x1.count(List(1,2,3))
  //x1.count(Set(1,2,3))
}
