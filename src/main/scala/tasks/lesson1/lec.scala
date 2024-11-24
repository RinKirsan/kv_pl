package tasks.lesson1


object HelloWorld {
  def main(args: Array[String]): Unit = {
    println(1 + 3)
    Console.out.println("cout")
  }
}

object HelloWorldWithApp extends App {
  println(2 + 3)
}


object TypesAndAllALL extends App{
  var x:Int = 2
  val x1:Int = 2
  x = 3 // не надо так делать
  //  x1 =3 // ругается

  val l1:Long = 1L
  var d1:Double = 1.0
  var d2:Double = 1d
  val str = "string"
  val char = 'c'
  private val div = 5 / 2
  val u:Unit = println(div)
  val b:Boolean = x == x1 //not equls!!
  println(b)

  // можно использовать когда непонятно или не время реализовать сейчас, например
  //  val n: Nothing = ???
  //  val n1: Nothing = throw new Exception("")

  import java.lang.{Long => jLong}
  val jL: Long = Long2long(jLong.getLong("1"))

  type PersonID = Long
  type ContactType = String
  type ContactValue = String
  type PersonContacts = Map[ContactValue, ContactType]

  val pmShmthg: Map[PersonID, PersonContacts] = Map(1L ->Map("email" -> "sc@ya.ru"))
}

object StringSmthng extends App{
  var x: Int = 1
  var x1: Int = 2

  val str1 = s"$x + $x1 = ${x + x1}"
  println(str1)
  println("---------------------")

  val str2 =
    """
      |a1a1a1a1
      |b2b2b2b2
      |""".stripMargin
  println(str2)
  println("---------------------")

  val str3 =
    """
      |c3c3c3c3
      |d4d4d4d4
      |""".stripMargin
  println(str3)
}

// Кортежи
object TupleSmthng extends App {
  val t1: (Int, Int, String, Boolean) = (1, 2,"str", true)
  println(t1._1)
  val t2: (Int, String) = 1 -> "2"
  println(t2, t2.productElementName(0))
  val t3: ((Int, String), Boolean) = 1 -> "2" -> true
  println(t3._1._2)
  val (i, s) = t2
  println(i)
}

object DefFun extends App {
  def printVar(name: String, any: Any): Unit = {
    println(s"$name: $any")
  }
  def myPrint (str: String): Unit = println(str)
  myPrint("s")
  def myPrint1(str: String, i: Int): Int = {
    println(i)
    println(str)
    i
  }
  val x1/*: Int*/ = myPrint1("s2", 3)
  printVar("x1", x1)

  val x2: Int => Int = myPrint1("s", _)
  x2(2)
  //printVar("x2", x2(2))

  def myPrint2(str: String)(i: Int): Int = {
    println(s"$str, $i")
    i
  }
  val x3: Int => Int = myPrint2("s")(_)
  x3(1)

  val x4: Int => Int = (i: Int) => i * 2
  x4.apply(2)
  val x5: Int => Int = i => i * 2
  val x6: Int => Int = _ * 2

}

object DefaultDefParam extends App {
  def myPrint3(str: String, i: Int, d: Double): Int = {
    println(i)
    println(str)
    i
  }
  myPrint3(
    d = 1d,
    str = "string",
    i = 4
  )
}
