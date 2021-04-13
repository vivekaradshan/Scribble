package lectures.part2oop

object OORef extends App{

  //Class and instance
  class Animal {
    //class - fields
    val age: Int = 0
    //class - methods
    def eat() = println("I'm eating")
  }
  val animal = new Animal //instanciate a class
  //Inheritance
  class Dog(val name:String) extends Animal //constructor definition
  val aDog = new Dog("Tommy") //class definition with constructor to instantiate an object

  //Constructor is not same as fields
  println(aDog.age) // Compiler will not complain when a field is called
  println(aDog.name) //If we call the constructor the compiler will complain.
  // In order to promote the constructor argument to field we need to add val. It will be a member of the class

  //subtype polymorphism
  val aDeclaredAnimal:Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() //Most derived method will be called at the runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true //all are public by default, can restrict by adding protected/private
    def walk():Unit
  }
  //interface - to denote ultimate abstract type
  trait Carnivore {
    def eat(animal:Animal):Unit
  }//trait generally used to later implement in concrete classes
  trait Carnivore1 {
    def sleep(animal:Animal):Unit
  }
  trait Philosopher {
    def ?!(thoughts:String):Unit //valid method
  }
  //Scala has single class inheritance and multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Carnivore1 with Philosopher {
    override def eat(animal:Animal) = println("I am going to eat you!")
    override def sleep(animal:Animal) = println("I am going to sleep!")
    override def ?!(thoughts:String)= println(s"I was thinking: $thoughts")
    //override concrete method from class Animal
    override def eat(): Unit = super.eat()
  }
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with one argument
  aCroc ?! "What if we could fly"

  //operators are methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1 .+(2)//equivalent

  //anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am dinosaur, I can eat anything!!!")
  }
  /*
  The compiler understands to create an anonymous class
  class Carnivore_Anonymous_3289 extends Carnivore {
    override def eat(animal: Animal): Unit = println("I am dinosaur, I can eat anything!!!")
  }
  val dinosaur = new Carnivore_Anonymous_3289
   */

  //Singleton object
  object mySingleton {
    val num = 2000
    def strFunc() = println("This is a function")
    def apply(x:Int) = x+1
  }

  mySingleton.strFunc()
  mySingleton.apply(65)
  println(mySingleton(65)) //equivalent to mySingleton.apply(65)

  //Companion Class - object can be applied to class/trait

  object Animal {
    //companions can access each other's private fields/methods
    //singleton Animal and instance of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely

  /*
  Case class
  Light weight data structures with some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with apply
   */
  case class Person(name:String, age:Int)
  val person = Person("Bob",45) //Similar to Person.apply("Bob",45) and new keyword is not required

  //Exceptions
  try {
    val x:String = null
    x.length
  }
  catch {
    case e:Exception => "some faulty code"
  }
  finally {
    //"The code that will always execute"
  }

  //generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  //Using generics with a concrete type
  val myStringList:List[String] = List("hello","world")
  val first = myStringList.head
  val last = myStringList.tail

  //#1. Scala operates on the concept of IMMUTABLE values/objects
  // Any modifications leads to new object
  /*Benefit:
  1.  works better in multithreaded environment
  2.  helps making sense of the code ("reasoning about")
   */
  val reverseObject = myStringList.reverse

  /*
  #2. Scala is the closest of OO ideal
   */
}
