package com.knoldus.oops

trait LoggerA {
  def log(category: String, msg: String): Unit = {
    println(msg)
  }
}

trait DataAccessA {
  def query[A](in: String)={}
}

trait LoggedDataAccess extends DataAccess with Logger {
  override def query[A](in: String) = {
    log("QUERY", in)
    super.query(in)
  }
}

object TraitComposition {

}