package com.knoldus.types

class T[+A] {} // Plus allowed, parents allowed

trait Function[A, B]
trait Function1[A, +B]  // Invariant type A but Children of Type B
trait Function2[-A, +B] // Parent of type A or A and Children of type B

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
  val b1 :Function1[String, Any] = new Function1[String, AnyRef] {} 
  //val b11 :Function1[String, Any] = new Function1[Any, AnyRef] {} 
  val b12 :Function1[String, Any] = new Function1[String, AnyRef] {} 
  val c1: Function1[Any, Any] = a1

  val a2 = new Function2[AnyRef, String] {}
  val b2: Function2[String, Any] = new Function2[AnyRef, String] {}
  val b21: Function2[String, Any] = new Function2[Any, String] {}
  
  //val c2: Function2[Any, String] = a2 // Trying to put [AnyRef,String] == [Child, Same]

}