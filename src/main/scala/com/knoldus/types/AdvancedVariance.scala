package com.knoldus.types

trait Lister[+ItemType] {
  def ++[AnotherType >: ItemType](other: Lister[AnotherType]): Lister[AnotherType]
}

class EmptyList[ItemType] extends Lister[ItemType] {
  def ++[AnotherType >: ItemType](other: Lister[AnotherType]) = other
}

object AdvancedVariance extends App {
  val combine1 = (new EmptyList[String]).++(new EmptyList[Any])
  val combine2 = (new EmptyList[AnyRef]).++(new EmptyList[AnyRef])
  val combine3 = (new EmptyList[AnyRef]).++(new EmptyList[Any])
  val combine4 = (new EmptyList[String]).++(new EmptyList[Int])
  val combine5 = (new EmptyList[Int]).++(new EmptyList[Int])
  val combine6 = (new EmptyList[Int]).++(new EmptyList[String])

  val g = List(1, 2, 3) ++ List("l")

}