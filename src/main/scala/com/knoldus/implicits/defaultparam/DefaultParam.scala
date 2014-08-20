package com.knoldus.implicits.defaultparam

class Math {
  
  def sum(x:Int, y:Int)(implicit z:Int = 0) = x+y+z
}


object DefaultParam extends App{

  //implicit val z:Int = 10
  //implicit val t:Int = 10
  println((new Math).sum(2,3))
}