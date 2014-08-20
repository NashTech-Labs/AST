package com.knoldus.types

trait List[+ItemType] {
  def ++[AnotherType >: ItemType](other: List[AnotherType]): List[AnotherType]
}

class EmptyList[ItemType] extends List[ItemType] {
  def ++[AnotherType >: ItemType](other: List[AnotherType]) = other
}

object AdvancedVariance extends App{
  val combine1 = (new EmptyList[String]).++(new EmptyList[Int])
  val combine2 = (new EmptyList[Any]).++(new EmptyList[AnyRef])
  val combine3 = (new EmptyList[AnyRef]).++(new EmptyList[String])
  val combine4 = (new EmptyList[AnyRef]).++(new EmptyList[Int])

}