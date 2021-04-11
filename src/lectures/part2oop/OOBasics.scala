package lectures.part2oop

object OOBasics {

  //Object means and extending a class mean
  object oopBasics extends App{

    //instantiation is memory and data structure which class describes
    val person = new Person("John",28)
      println(person)
  }

  //Class organizes the data and code
  class Person(name:String, age:Int) //constructor - every single instantiation of person should have name and age passed
}
