package lectures.part1basics

object Functions extends App{
  def aFunction(a:String,b:Int):String = {
    a+' '+b
  }
  println(aFunction("Hello", 5))

  //Recursive Functions
  def repeatedFuntion(aString:String,n:Int):String = {
    if (n == 1) aString
    else aString + ' '+ repeatedFuntion(aString, n-1)
  }

  println(repeatedFuntion("Hello", 5))
 //SideEffects with Unit as return statement
  def aFunctionWithSideEffects = {
    println("Hello World")
  }
  //Auxillary function -> A function inside a function
  def aBiggerFuntion(n:Int):Int = {
    def aSmallerFunction(a:Int,b:Int):Int = a + b
    aSmallerFunction(n, n-1)
  }

  //1. A greeting function for kids
  def aGreeting(name:String, age:Int):Unit = {
    println(s"Hi, my name is $name and I am $age years old")
  }
  aGreeting("viveka",28)

  //2.Factorial function
  def aFactorial(n:Int):Int = {
    if (n <= 0) 1
    else n * aFactorial(n-1)
  }
  println(aFactorial(5))

  //3.Fibonacci Function
  def aFibonacci(num:Int):Int = {
    if (num <= 2) 1
    else aFibonacci(num - 1) + aFibonacci(num - 2)
  }
  println(aFibonacci(6))

  //4.Number is Prime
  def isPrime(n:Int):Boolean = {
    def isPrimeUntil(t:Int):Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
  println(isPrime(17))
  println(isPrime(17*37))
}
