package lectures.part2oop

object Exceptions extends App{

  val x:String = null
//  println(x.length) -> this will crash with NPE
  // 1. throwing and catching exceptions

  //val aWeirdException:String = throw new NullPointerException

  //throwable class extends throwable class
  //Exception and Error are the major throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions:Boolean):Int = {
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42
  }

  val potentialfail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  }
  finally { //optional - doesnot influence the return type of the exception
    //finally are side effects - use when you really want to
    //code that will get executed no matter what
    println("finally")
  }

  println(potentialfail)

  //3. How to define our own exceptions
  class Myexception extends Exception {
    val exception = new Exception
  }
}
