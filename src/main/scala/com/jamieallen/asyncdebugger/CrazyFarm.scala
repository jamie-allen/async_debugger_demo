package com.jamieallen.asyncdebugger

import scala.util.Random._
import akka.actor._
import akka.event.LoggingReceive

class RandomSpeakingAnimal extends Actor with ActorLogging {
  def receive = LoggingReceive {
    case myWords: Speak =>
      log.info(s"I am a ${self.path.name} and I say ${myWords.whatToSay}")
      CrazyFarm.getRandomAnimal ! Speak(CrazyFarm.getRandomMessage)
  }
}

case class Speak(whatToSay: String)

object CrazyFarm {
  // Define the messages and how they are used
  val messages = Vector("Woof", "Meow", "Quack", "Moo", "Baa")
  def getRandomMessage: String = messages.toVector(nextInt(messages.size))
  
  val system = ActorSystem("animal_farm")
  val dog = system.actorOf(Props[RandomSpeakingAnimal], "dog")
  val cat = system.actorOf(Props[RandomSpeakingAnimal], "cat")
  val cow = system.actorOf(Props[RandomSpeakingAnimal], "cow")
  val duck = system.actorOf(Props[RandomSpeakingAnimal], "duck")
  val sheep = system.actorOf(Props[RandomSpeakingAnimal], "sheep")
  val animals = Vector(dog, cat, cow, duck, sheep)
  def getRandomAnimal: ActorRef = animals.toVector(nextInt(animals.size))
  
  def main(args: Array[String]) = {
    val who = getRandomAnimal
    val what = getRandomMessage
    who ! Speak(what)
  }
}
