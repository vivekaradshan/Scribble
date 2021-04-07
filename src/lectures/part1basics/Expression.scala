package lectures.part1basics

object Expression extends App{
  val x = 1+2
  println(x)
  println(x == 3)
  // == != > >= <= <
  println(!(x == 5))
  // ! && ||

  var aVariable = 3
  aVariable +=4
  println(aVariable) //side effects

  //Instructions (DO) vs Expression (VALUE)
  val aCondition = true
  //IF expression
  val aConditionExpression = if (aCondition) 5 else 3
  println(aConditionExpression)

  var i = 0
  while (i < 10) {
    print(i)
    i += 1
  }

  val aWierdValue = (aVariable = 5) // Unit === void
  println(aWierdValue)

  //side effects: println(), whiles, reassigning
  //Code blocks
  val aCodeBlocks = {
    val y = 2
    val z = y + 1
    if (z>2) "hello" else "goodbye"
  }
  //The value of the block is equal to its expressions; Everything remains within the block and it cannot be called outside

}

