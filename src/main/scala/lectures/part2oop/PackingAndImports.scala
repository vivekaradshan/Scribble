package main.scala.lectures.part2oop


import playground.Cinderalla

object PackingAndImports extends App{

  //package members are accessible by their simple names
  val writer = new Writer("Viveka","ScalaLearning",2021)

  //import package
  val princess = new Cinderalla //import the package if they don't fall in same package
  val human = new com.learningscala.FunctionalProgramming.TempPerson //We can call the class with the package

  // package are in hierarchy
}
