package lectures.part2oop

object Generics extends App{

  class MyList[A] {

  }
  class myMap[Key,Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A] : MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //1.  List[Cat] extends List[Animal] - Covarience
  class CovarientList[+A]
  val animal:Animal = new Cat
  val animallist: CovarientList[Animal] = new CovarientList[Cat]

  //2.  Invariance
  class invarient
}
