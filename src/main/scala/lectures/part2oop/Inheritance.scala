package lectures.part2oop

object Inheritance extends App{

  //single class inheritance
  class Animal {
    val creatureType = "Wild Animal"
    def eat = println("nomnom")
    private def sleep = println("zzzz")
    protected def walk = println("walk walk!!")
  }
  class Cat extends Animal {
    def crawl = {
      walk // protected is only accessible in sub-class not outside
      println("crawl crawl!!")
    }
  }
  val cat = new Cat
  cat.eat
//  cat.sleep -> private members are inaccesible
//  cat.walk -> protected members are inaccesible

//Constructors
  class Person(name:String,age:Int) {
  def this(name:String) = this(name,0)
}
  class Adult(name:String,age:Int,idcard:String) extends Person(name) //valid because of auxillary class this(name,0)

//Overriding
class Dog(override val creatureType: String) extends Animal {
//  override val creatureType: String = "Domestic"
  override def eat: Unit = {
    super.eat //super - when we want to refer method/field from parent class
    println("crunch, crunch")
  }
}
  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

class Goat(GoatType: String) extends Animal {
  override val creatureType: String = GoatType
  override def eat: Unit = println("munch, munch")
}
  val goat = new Goat("Herbivore")
  println(goat.creatureType)

  //type substitution - polymorphism
  //A method goes to most overridden version whenever possible
  val unknownAnimal:Animal = new Dog("Canine")
  unknownAnimal.eat

  //overriding - different implementation in derived classes
  //overloading - supplying multiple methods with different signatures but with same name under same class

  //preventing overrides - put the keyword final
  //final def eat = println("nomnom")
  //final can be used even with class so you cannot extend the class
  //seal the class - extend the class in this file and not in other files
}

