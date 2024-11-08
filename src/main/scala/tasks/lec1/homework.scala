package tasks.lec1

object task1 extends App {
  def square (num: Double): Unit = {
    println(s"$num - ${num * num}")
  }
  def square (num: Double, r: Int): Unit = {
    printf(s"$num - %.${r}f\n", num * num)

  }
  square(3d)
  square(1.5)
  square(4.68, 3)
}

object task2 extends App {
  def area(r: Double): Unit = {
    val s = r*r*Math.PI
    println(s"The area of the circle: $s")
  }
  area(2)
  area(1.6)
}

object task3 extends App {
  def tempFar(t: Double,r: Int = 1): Unit = {
    printf(s"temperature - %.${r}f\n", t * 1.8d + 32)
  }

  tempFar(12)
  tempFar(-24)
  tempFar(-24, 3)
  tempFar(65)
}

object task4 extends App {
  def count(str: String): Unit = {
    println(s"Line length \"$str\": ${str.length}")
  }
  count("aaaaa")
}