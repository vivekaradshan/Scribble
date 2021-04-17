package lectures.part2oop

object Caseclasses extends App{

  case class Person(name:String, age:Int)

  //1.  class parameters are promoted to fields
  val jim = new Person("Jim",24)
  println(jim.age)

  //2.  sensible toString
  println(jim.toString)
  println(jim)

  //3.  equals and hashcode implemented out of the box
  val jim2 = new Person("Jim",24)
  println(jim == jim2) //if it was not a case class it would have
  // returned false because they are different instance of a class

  //4. CCs have handy copy method
  val jim3 = jim.copy(age=45)
  println(jim3)

  //5. CCs can have companion objects
  val thePerson = Person //companion object of a CC. It is created by default
  val mary = Person.apply("mary",23)
  println(mary)

  //6. CCs are serializable - which make it useful in distributed system to send them through the network
  //7. CCs have extractor patterns - CCs can be used in pattern matching

  case object India {
    def name:String = "India is peninsula"
  }
}
