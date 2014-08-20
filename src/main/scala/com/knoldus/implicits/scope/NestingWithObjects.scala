package com.knoldus.implicits.scope

object Foo1 {
  object Bar { override def toString = "Bar" }
  implicit def b : Bar.type = Bar
}

object Nesting1 extends App {
  implicitly[Foo1.Bar.type]
}
