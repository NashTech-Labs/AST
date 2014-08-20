package com.knoldus.implicits.scope

object holder {
  trait Foo
  object Foo {
    implicit val x = new Foo {
      override def toString = "Companion Foo"
    }
    implicit val list = List(new Foo {})
  }
}
class Accessor {
  import holder.Foo
  def method(implicit foo: Foo) = {
    println(foo)
    val arg =implicitly[List[holder.Foo]] 
    println(arg(0))
  }
}


object tester extends App {
  (new Accessor).method
}