package lectures.part2oop

object AnonymousClass extends App{
  abstract class Animal {
    def eat:Unit
  }
  //Anonymous Class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("hahahahhaaa")
  }
  /* equivalent implementation
  class AnonymousClass$$anon$1 extends Animal {
   override def eat: Unit = println("hahahahhaaa")
 } */
  println(funnyAnimal.getClass)

  class Person(name:String) {
    def sayHi:Unit = println(s"Hi, my name is $name, How can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, How can I help?")
  }

}
