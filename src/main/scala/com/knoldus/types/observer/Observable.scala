package com.knoldus.types.observer

trait Observable {
  type Handle
  protected var callbacks = Map[Handle, this.type => Unit]()
  def observe(callbackMethod: this.type => Unit): Handle = {
    val handle = createHandle(callbackMethod)
    callbacks += (handle -> callbackMethod)
    handle
  }
  def unobserve(handle: Handle): Unit = {
    callbacks -= handle
  }
  protected def notifyListeners(): Unit =
    for (callBackMethod <- callbacks.values) callBackMethod(this)
  /**
   * Subclasses override this to provide their own callback disambiguation scheme.
   */
  protected def createHandle(callback: this.type => Unit): Handle
}

trait DefaultHandles extends Observable {
  type Handle = (this.type => Unit)
  protected def createHandle(callback: this.type => Unit): Handle = callback
}

class IntStore(private var value: Int) extends Observable with DefaultHandles {
  def get: Int = value
  def set(newValue: Int): Unit = {
    value = newValue
    notifyListeners()
  }
  def goo(x: this.type) = println("yes")
  override def toString: String = "IntStore(" + value + ")"
}

object letstest extends App {
  val callback = println(_: Any)
  val x = new IntStore(5)
  val handle = x.observe(callback)
  x.set(10)
  x.unobserve(handle)
  x.set(9)
  val y = new IntStore(15)
  val handle2 = y.observe(callback)
  println(handle == handle2)
  //y.unobserve(handle)
  y.unobserve(handle2)
}