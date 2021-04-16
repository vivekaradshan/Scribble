package lectures.part2oop

object MethodNotations extends App{
  class Person(val name:String,fav_movie:String, val age:Int=0) {
    def likes(movie:String) = fav_movie
    def hangOutWith(person:Person) = s"${this.name} likes to hangout with ${person.name}"
    def +(person:Person) = s"${this.name} likes to hangout with ${person.name}"
    def +(nickname:String):Person = new Person(s"$name ($nickname)",fav_movie)
    def unary_! : String = s"$name, What the heck?!"
    def unary_+ :Person = new Person(name,fav_movie, age + 1)
    def isAlive : Boolean = true
    def apply() : String = s"Hi, my name is $name and my favourite movie is $fav_movie"
    def apply(num:Int):String = s"$name watched $fav_movie $num times"
    def learns(language:String):String = s"$name learns $language"
    def learnsScala():String = learns("Scala")
  }

  val mary = new Person("Mary", "inception",age = 12)
  println(mary.likes("inception"))
  println(mary likes "inception") //equivalent
  //infix notation = operator notation (syntatic sugar) - works only for methods with one parameter

  //"Operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(tom hangOutWith mary)
  println(tom + mary)
  println(tom.+(mary))
  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS
  //prefix notation
  val x = -1
  val y = 1.unary_- //equivalent
  //unary_ prefix only works with - + ~ ! operators
  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent

  /*
  1.  Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"
   */
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  /*
    2. Add age to the class Person
    Add a unary + operator => new Person with age + 1
    + mary => Mary with the age incrementer
   */
  println((+mary).age)

  /*
  Add a learns method in the class Person => "Mary learns Scala"
  learns scala method without any parameter and calls the learn method with "Scala" as parameter
  Use it in postfix notation
   */
  println(mary learns "Scala")
  println(mary learnsScala)

  /*
  4.  Overload the apply method
      Mary.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary(2))
}
