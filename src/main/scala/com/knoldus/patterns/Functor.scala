package com.knoldus.patterns

class MyBox[T](val value: T)

object Functor extends App {
  val boxedstring: MyBox[String] = new MyBox("Hello")

  //Functor
  def map[A, B](rawfunc: A => B): MyBox[A] => MyBox[B] = (a: MyBox[A]) => new MyBox(rawfunc(a.value))
  //String => Int
  def rawLengthOf(a: String): Int = a.length // the raw function we want to use
  // MyBox[String]=>MyBox[Int]
  val functorFunction = map(rawLengthOf) // applying the transformation, so we get our new function
  def functorTransform(boxedstring: MyBox[String]): MyBox[Int] = functorFunction(boxedstring) // applying the new function

  val h = functorTransform(new MyBox("Hello"))

  println(h)

  //Monad
  def flatMap[A, B](func: A => MyBox[B]): MyBox[A] => MyBox[B] = (a: MyBox[A]) => func(a.value)
  // String => MyBox[Int]
  def lengthOf(a: String) = new MyBox(a.length) // a function which takes a raw type but boxes the result itself
  // MyBox[String]=>MyBox[Int]
  val monadFunction = flatMap(lengthOf)
  def monadTransform(boxedstring: MyBox[String]): MyBox[Int] = monadFunction(boxedstring)

  val m = monadTransform(new MyBox("Hello"))

  println(m)

  //Applicative
  def apply[A, B](b: MyBox[A => B]): MyBox[A] => MyBox[B] = (a: MyBox[A]) => new MyBox(b.value(a.value))
  //MyBox[String=>Int]
  val boxedLengthOf: MyBox[String => Int] = new MyBox(rawLengthOf _)
  // MyBox[String]=>MyBox[Int]
  val applicativeFunction = apply(boxedLengthOf)
  def applicativeTransform(boxedstring: MyBox[String]): MyBox[Int] = applicativeFunction(boxedstring)

  val a = applicativeTransform(new MyBox("Hello"))

  println(a)

}