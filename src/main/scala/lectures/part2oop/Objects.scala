package lectures.part2oop

object Objects {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static") - Object is something that has static like functionality
  object Person { //type + only instance
    /** STATIC/CLASS LEVEL FUNCTIONALITY **/
    /*
    1.  Objects are similar to classes except they donot have parameters
    2.  Objects are singleton notation in Scala
    */
    val N_EYES = 2
    def canFly:Boolean = true
    def apply(mother:Person,father:Person) = new Person("Bobie")
  }

  class Person(name:String) {
    // instance level functionality
  } //Companions - reside in same scope and have same name
  def main(args: Array[String]) {

    println(Person.N_EYES)
    println(Person.canFly)
    val mary = Person
    val john = Person
    println(mary == john) // Point to same instance
    val mary1 = new Person("mary")
    val john1 = new Person("john")
    println(mary1 == john1) // Different instance

    val bobiee = Person(mary1,john1)}

  //Scala Application - Only a scala object with below method implemented in it
  //def main(args: Array[String]):Unit - Scala application are converted to Java virtual machine object with
  //public static void main with array of objects
}
