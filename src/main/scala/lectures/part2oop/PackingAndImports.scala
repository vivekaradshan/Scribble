package main.scala.lectures.part2oop


import playground.{Cinderalla, PrinceCharming => Prince}

import java.util.Date // grouped together else we can use playground._
//Aliasing the package PrinceCharming => Prince
import java.util
import java.sql.{Date => SqlDate}

object PackingAndImports extends App{

  //package members are accessible by their simple names
  val writer = new Writer("Viveka","ScalaLearning",2021)

  //import package
  val princess = new Cinderalla //import the package if they don't fall in same package
  val prince = new Prince
  val human = new com.learningscala.FunctionalProgramming.TempPerson //We can call the class with the package

  // package are in hierarchy
  // matching folder structure

  //package object
  sayHello
  println(SPEED_OF_LIGHT)

  //importing Date
  //1. Use fully qualified name
  //2. Use aliasing
  val date = new Date()
  val sqlDate = new SqlDate(2018,12,3)

  //Default imports
  //java.lang => String,Object,Exception
  //scala package => Int,Nothing,Function
  //scala.Predef => println, ???

}
