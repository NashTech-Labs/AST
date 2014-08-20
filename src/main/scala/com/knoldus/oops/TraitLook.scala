package com.knoldus.oops

trait Property {
  val name: String
  override val toString = "Property(" + name + ")"
}

class X extends { val name = "Early initializing" } with Property

object TraitLook extends App {
  val x = new Property { override val name = "Some String" }
  println(x)
  println(new X)
  
  println(new {val name="Anonymous?"} with Property)
}

