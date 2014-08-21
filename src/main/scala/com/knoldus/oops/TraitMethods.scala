package com.knoldus.oops

trait Foo {
  def someMethod(): Int = 5
}
class Main() extends Foo {
}

object ScalaMain {
  def main(args: Array[String]) {
    val foo: Foo = new Main();
    println(foo.someMethod());
    //println(foo.newMethod());
  }
}