package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{
  def aFactorial(n:Int):Int = {
    if (n <= 0) 1
    else {
      println(s"Computing factorial of $n, I need fatorial of "+(n-1))
      val result = n * aFactorial(n-1)
      println(s"Computed factorial of $n")

      result
    }
  }
  //The JVM adds everything to the stack which has limited memory which could cause stackoverflow error.
  //StackOverflowError happens when the recursive depth is too high
  println(aFactorial(10))

  def anotherFactorial(n:Int):BigInt = {
    @tailrec //annotation to understand it as tail recursion
    def factorialHelper(x:Int, accumulator:BigInt):BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x-1,x * accumulator)
    }
    factorialHelper(n,1)
  }
  println(anotherFactorial(100))

  /*
  First factorialHelper is being called
  factorialHelper(10,1)
  it moves to the else block
  = factorialHelper(9,10*1)
  = factorialHelper(8,10*9*1)
  = factorialHelper(7,10*9*8*1)
  = factorialHelper(6,10*9*8*7*1)
  ..........
  = factorialHelper(2,3*4*....*10)
  = factorialHelper(1,2*3*4*....*10)
   */
  //The reason why this worked is we wrote factorialHelper as last expression of the code block
  //It doesn't save the intermediate results in the stack and this is called tail recursion
  //intellij identifies it as tail recursion

  /*
  1. Concatenate a string n times
  2.  isPrime in tail recursion
  3.  Fibanacci in tail recursion
   */

  //  1. Concatenate a string n times
  def stringConcat(str:String, n:Int, accumulator:String):String = {
    if (n <= 0) accumulator
    else stringConcat(str,n-1,str+accumulator)
  }
  println(stringConcat("Hello",5,""))

  //  2.  isPrime in tail recursion
  def isPrime(n:Int):Boolean = {
    def isPrimeUntil(t:Int, isStillPrime:Boolean):Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil((t-1),n % t != 0 && isStillPrime)
    }
    isPrimeUntil(n/2, true)
  }
  println(isPrime(500))
  println(isPrime(503))
/*
  // 3.  Fibanacci in tail recursion
  def aFibonacci(num:Int):Int = {
    if (num <= 2) 1
    else {
      println(s"The Fibonacci number is $num")
      val result :Int = aFibonacci(num - 1) + aFibonacci(num - 2)
      println(s"The calculated number is $result")

      result
    }
  }
  println(aFibonacci(6))
*/
  def aFibonacciTailrec(n:Int):Int = {
    def aHelper(x:Int,last:Int,nextToLast:Int):Int = {
      if (x >= n) last
      else aHelper(x+1, last+nextToLast,last)
    }
    if (n <= 2) 1
    else aHelper(2,1,1)
  }
  println(aFibonacciTailrec(6))
}
