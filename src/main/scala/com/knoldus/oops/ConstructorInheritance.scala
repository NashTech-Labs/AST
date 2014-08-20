package com.knoldus.oops

class DataAccessor(val logger: Logger = new Logger {}) {
  def query[A](in: String): A = {
    logger.log("QUERY", in)
    None.asInstanceOf[A]
  }
}

trait MyLogger extends Logger {
  override def log(category: String, msg: String): Unit = {
    println(msg + msg + msg)
  }
}

object ConstructorInheritance extends App {

  val da = new DataAccessor(new MyLogger {})
  da.query("hi")

  val da1 = new DataAccessor
  da1.query("hi")

}	

