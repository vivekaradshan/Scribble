package lectures.part2oop

object InheritanceAndTraits extends App{

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
  override def eat: Unit = println("crunch, crunch")
}
  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

class Goat(GoatType: String) extends Animal {
  override val creatureType: String = GoatType
  override def eat: Unit = println("crunch, crunch")
}
  val goat = new Goat("Herbivore")
  println(goat.creatureType)

  //type substitution - polymorphism
  val unknownAnimal = new Dog("")


}

