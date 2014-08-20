package com.knoldus.types

class Egg {
  trait Yolk
  def yolker = new Yolk{}
  def boil(x: this.type#Yolk) = println("Tight Boiling")
  def mash(x: Egg#Yolk) = println("Any mashing")
}

object Egger extends App{
	val egg = new Egg
	val yolkerInsider = egg.yolker
	egg.boil(yolkerInsider)
	egg.mash(yolkerInsider)
	
	val eggAgain = new Egg
	val yolkerAnotherInsider = eggAgain.yolker
	
	egg.mash(yolkerAnotherInsider)
	//egg.boil(yolkerAnotherInsider)
	
}

