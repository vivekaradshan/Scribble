package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning scala"
  println(str.charAt(2))
  println(str.substring(2,4))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toUpperCase)
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println(aNumber)
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  //String interpolation
  val name = "David"
  val age = 28
  println(s"Hello my name is $name and age is ${age+20}")

  //F-interpolation
  val speed = 2.2f
  println(f"$name can eat $speed%2.2f burgers per minute")

  //Raw interpolator
  val escaped = "This a \\n character"
  println(raw"This a \n character") //Backslash will be escaped
  println(raw"$escaped") //Backslash will be escaped
}
