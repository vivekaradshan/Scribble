package lectures.part2oop

object Exceptions extends App{

  val x:String = null
//  println(x.length) -> this will crash with NPE
  // 1. throwing and catching exceptions

  //val aWeirdException:String = throw new NullPointerException

  //throwable class extends throwable class
  //Exception[something went wrong with the program - NullPointerException] and Error[wrong with the JVM - StackOverFlow]
  // are the major throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions:Boolean):Int = {
    if (withExceptions) throw new RuntimeException("No Int for you")
      //Exceptions come from jvm they are java specific and not scala specific
    else 42
  }

  val potentialfail = try { //Return type is AnyVal because try block provides int and catch block Unit
    getInt(true)
  } catch {
    case e: RuntimeException => "There is an RuntimeException"
  }
  finally { //optional - doesnot influence the return type of the exception
    //finally are side effects - use when you really want to
    //code that will get executed no matter what
    println("finally")
  }

  println(potentialfail)

  //3. How to define our own exceptions
  class MyException extends Exception
    val exception = new MyException
    //throw exception //create your own exception

  /*
  1.  Crash your program with OOM error
  2.  Crash with StackOverFlow
  3.  PockectCalculator
      -add(x,y)
      -sub(x,y)
      -multiply(x,y)
      -divide(x,y)
   */

//  1.  Crash your program with OOM error
//  val maxArray = Array.ofDim(Int.MaxValue)
//  2.  Crash with StackOverFlow
//  def inifinte:Int = 1 + inifinte
//  val noLimit = inifinte

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division By Zero")

  object PocketCalculator {
    def add(x:Int,y:Int):Int = {
      val result = x + y
      if (x>0 && y>0 && result<0) throw new OverFlowException
      else if (x<0 && y<0 && result>0) throw new UnderFlowException
      else result
    }
    def sub(x:Int,y:Int):Int = {
      val result = x - y
      if (x>0 && y<0 && result<0) throw new OverFlowException
      else if (x<0 && y>0 && result>0) throw new UnderFlowException
      else result
    }
    def divide(x:Int,y:Int):Int = {
      if (y == 0 ) throw new MathCalculationException
      else x / y
    }
    def multiply(x:Int,y:Int):Int = {
      val result = x * y
      if (x>0 && y>0 && result<0) throw new OverFlowException
      else if (x<0 && y<0 && result<0) throw new OverFlowException
      else if (x>0 && y<0 && result>0) throw new UnderFlowException
      else if (x<0 && y>0 && result<0) throw new UnderFlowException
      else result
    }
  }
//  PocketCalculator.add(Int.MaxValue,10)
  PocketCalculator.divide(2,0)
}
