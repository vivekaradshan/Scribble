package lectures.part2oop

object OOBasics extends App {

  //Object means and extending a class mean


    //instantiation is memory and data structure which class describes
    val person = new Person("John",28)
      println(person.x)
      person.greet("Daniel")
      person.greet()

    val writer = new Writer("Adam","Grant",1980)
    val novel = new Novel("Originals",2020,writer)
    println(novel.authorAge)
    println(novel.writtenBy(writer))
    println(novel.copy(2021))
  }

  //Class organizes the data and code
  //constructor - every single instantiation of person should have name and age passed
  //Class parameters are not fields - But it can be made as a member by adding val to it
  class Person(name:String,val age:Int) {
    //Body
    val x = 2
    println(1+3)

    //Method
    def greet(name:String): Unit ={
      println(s"$name says,Hi $name")
      //Calling class parameter
      println(s"${this.name} says,Hi $name")
    }

    //overloading - defining methods with the same name by different signatures.
    //But if you pass the same set of signatures (different number of parameters/parameter of different types
    // coupled with different return type) then compiler will not permit it
    def greet() = println(s"Hi, this is $name")

    //multiple constructor
    def this(name:String) = this(name,0)
    def this() = this("John Doe") //Only way to implement it is using new auxillary parameter which makes usage impartical

  }

/* Novel and writer class -
  writer: first name, surname and year of birth
    method: fullname concat (first and surname)
  novel: name, year of release, author(instance of type writer)
    method: authorAge at year of release
            iswrittenBy(author)
            copy() */
   class Writer(fname:String, lname:String, val dob:Int) {
          def fullname = fname + " " + lname
  }
  class Novel(name:String,year_of_release:Int,author:Writer){
    def authorAge(): Int = year_of_release - author.dob
    def writtenBy(author:Writer) = author == this.author
    def copy(newYear:Int):Novel = new Novel(name,newYear,author)
  }


