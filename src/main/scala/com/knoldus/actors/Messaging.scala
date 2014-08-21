package com.knoldus.actors

import akka.actor.ActorLogging
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.actor.ActorRef
import akka.util.Timeout

class MessageActor extends Actor with ActorLogging {

  def receive = {
    case _ => log info (s"Ok, i got it from $sender")
  }

}

class MessageSender(messageActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case SendMessage => {
      log info (s"The sender to this actor is $sender")
      messageActor ! "Hi"
      messageActor.forward("Hi")
    }
  }

}

case object SendMessage

object Tester extends App {

  implicit val timeout = Timeout(5.seconds)
  val system = ActorSystem("MessageSimulation")
  val messageActor = system.actorOf(Props[MessageActor])
  val messageSender = system.actorOf(Props(new MessageSender(messageActor)), "Sender")
  messageSender ! SendMessage
}