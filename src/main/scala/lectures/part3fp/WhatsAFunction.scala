package main.scala.lectures.part3fp

object WhatsAFunction extends App{
  // use functions as first class elements
  val doubler = new Function[Int,Int] { //first parameter is the input type and next is output type
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToIntConverter = new Function[String,Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("3")+4)

  val adder:((Int,Int)=>Int) = new Function2[Int,Int,Int] {
    override def apply(a:Int,b:Int):Int = a+b
  }

  //Function types Function2[A,B,R] === (A,B) => R
  //ALL SCALA FUNCTIONS ARE OBJECTS -> Instances of classes deriving from Function1,Function2 etc till 21

  /*
  1.  a function takes 2 strings and concatenates them
   */
  val stringConcat:((String,String)=>String) = new Function2[String,String,String] {
    override def apply(a:String,b:String) = a+b
  }
  println(stringConcat("Hello","Scala"))

  //Function1[Int,Function1[Int,Int]]
  val superAdder:Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]] {
    override def apply(x:Int):Function1[Int,Int] = new Function[Int,Int] {
      override def apply(y:Int):Int = x+y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(10)) //curried function - a function acts as input for another function. It takes multiple parameters as input


}

//class MyFunction[A,B] {
//  def apply(element:A):B = ???
//}