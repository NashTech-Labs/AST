package com.knoldus.types

class T[+A] {} // Plus allowed, parents allowed

trait Function[A, B]
trait Function1[A, +B]
trait Function2[-A, +B] // Children of type A and parents of type B

object Variance extends App {
  val x = new T[AnyRef]
  val y: T[Any] = x
  //val z: T[String] = x

  def foo(x: Any): String = "Hello " + x

  println(foo("Here i come"))

  def bar(x: String): Any = foo(x)

  println(bar("Here i come"))

  //
  val a = new Function[Any, String] {}
  //val b:Function[String, Any] = a
  //val c:Function[Any,Any] = a

  val a1 = new Function1[Any, String] {}
  //val b1 :Function1[String, Any] = a1 
  val c1: Function1[Any, Any] = a1

  val a2 = new Function2[Any, String] {}
  val b2: Function2[String, Any] = a2
  val c2: Function2[Any, String] = a2

}