package lectures.part2oop

object AbstractDataTypes extends App{
  //Abstract class cannot be instantiated
  abstract class Animal {
    val creatureType:String = "Wild"
    def eat:Unit
  }

  class Dog extends Animal { //extending abstract class override keyword is not really necessary
    override val creatureType: String = "Canine"
    def eat = println("crunch crunch")
  }

  //traits - ultimate abstract classes
  //they can be inherited along classes
  //traits different from abstract classes
  // 1. traits donot have constructor parameter
  // 2. multiple traits may be inherited by the same class
  // 3. trait are behaviour, an abstract class is a type of thing

  trait Carnivore {
    def eat(animal: Animal):Unit
    val preferredMeal = "fresh meat"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Omnivorous"
    override def eat: Unit = println("nomnom")
    override def eat(animal: Animal): Unit = println(s"I'm a croc and I am eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)
}
