package com.learningscala

object FunctionalProgramming extends App {

  //Scala is OO
  class Person(name:String) {
    def apply(age:Int) = println(s"Hi, I am $name and my age is $age")
  }
  val bob = new Person("Bob")
  bob.apply(29)
  bob(29)

  /*
  Scala runs on JVM
  Functional Programming
  1.  compose functions
  2.  pass functions as args
  3.  returns functions as results
   */

  val simpleIncrementor = new Function1[Int,Int] {
    override def apply(v1: Int): Int = v1+1
  }
  simpleIncrementor.apply(23)
  simpleIncrementor(23)

  //ALL SCALA FUNCTIONS ARE INSTANCE OF FUNCTIONS

  val stringConcatenation = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  stringConcatenation("Hello","Viveka")

  //Syntatic sugar
  val doubler: Int => Int = (x:Int) => 2*x
  doubler(4)

  val doubler1 = (x:Int) => 2*x
  doubler(4)

  /* equivalent to much longer
    val doubler = new Function1[Int,Int] {
     override def apply(x:Int):Int = 2*x
     }
    doubler(4)
   */

  //higher-order functions: take functions as argument or return functions as results
  val aMappedList:List[Int] = List(1,2,3).map(x => x+1)
  println(aMappedList)
  val aFlatMapList = List(1,2,3).flatMap(x => List(x,x*2)) //purpose of flatMap is to concatenate the list of (1,2),(2,4),(3,6)
  println(aFlatMapList)
  val aFilteredList = List(1,2,3,4,5).filter(x => x <=3)
  val aFilteredListShorter = List(1,2,3,4,5).filter(_ <=3)
  println(aFilteredList)

  //all pairs between numbers 1,2,3 and letters 'a','b','c'
  val allPairs = List(1,2,3).flatMap(numbers => List('a','b','c').map(letters => s"$numbers-$letters"))
  //for every number append List('a','b','c') and create $numbers-$letters
  println(allPairs)

  //for comprehension
  val alternatePairs = for {
  numbers <- List(1,2,3)
  letters <- List('a','b','c')
  } yield s"$numbers-$letters"
  println(alternatePairs)

  /*
  COLLECTIONS
   */

  //lists
  val aList = List(1,2,3,4)
  val firstElement = aList.head
  val rest = aList.tail
  val prependList = 0 :: aList
  val appendList = 0 +: aList :+ 10

  //Sequence
  val aSequence = Seq(1,2,3)
  val firstSeqElement = aSequence(1)

  //Vectors - faster retrival
  val aVector = Vector(1,2,3,4,5)

  //Sets - no duplicates
  val aSet = Set(1,2,3,4,1,2)
  val aSetContains = aSet.contains(5)
  val anAddedSubSet = aSet + 5 - 3
  println(anAddedSubSet)

  //ranges
  val aRange = 1 to 2000
  val doubledRange = aRange.map(_*2).toList

  //tuples - group of values under the same value
  val aTuple = ("Hello","Good Morning", 123)

  //Map
  val aPhoneBook: Map[String, Int] = Map(
    ("John", 1234),
    "Kevin" -> 5678 //same as ("Kevin",5678)
  )
  print(aPhoneBook)
}
