package com.knoldus

trait Cat
trait Bird
trait Catch
trait FullTummy

class Functional {
  def catchIt(hunter: Cat, prey: Bird): Cat with Catch = ???
  def eat(consumer: Cat with Catch): Cat with FullTummy = ???
}

object FuncTest extends App {
  val f = new Functional
  val letsCatch = f.catchIt(new Cat {}, _: Bird)
  val letsEat = f.eat(_)
  val story = letsCatch andThen letsEat
  story(new Bird {})
}