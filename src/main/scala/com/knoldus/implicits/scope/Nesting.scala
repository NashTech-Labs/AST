package com.knoldus.implicits.scope

object Foo {
  trait Bar
  implicit def newBar = new Bar {
    println("hello")
    override def toString = "Implicit Bar"
  }
}

object Nesting extends App {
  Foo.newBar
  implicitly[Foo.Bar]
}
