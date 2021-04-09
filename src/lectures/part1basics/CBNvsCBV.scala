package lectures.part1basics

object CBNvsCBV extends App {
  //The value of System.nanoTime() is computed initially before passing it as Value
  /*
  by value: 45914891789500
  by value: 45914891789500
  */

  def callByValue(x : Long):Unit = {
    println("by value: "+ x)
    println("by value: "+ x)
  }
  //The value of System.nanoTime() is computed only while passing it as Value
  /*
  by value: 45914978635400
  by value: 45914978699200
   */
  def callByName(x : => Long):Unit = {
    println("by name: "+ x)
    println("by name: "+ x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infiniteFunction():Int = 1 + infiniteFunction()
  def printFirst(x:Int, y: => Int) = println(x)

  //printFirst(infiniteFunction(),34) //It will cause StackOverFlow error as infiniteFunction is callByValue
  printFirst(34, infiniteFunction()) //It will execute fine since infiniteFunction is called by callByName and never used in the function
}
