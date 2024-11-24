package tasks.lesson1

object task1 extends App {
  def square (num: Double): Unit = {
    println(s"$num - ${num * num}")
  }
  def square (num: Double, r: Int): Unit = {
    println(s"$num - ${tool.round(num * num, r)}")

  }
  square(3d)
  square(1.5)
  square(4.68)
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
  def temperatureFahrenheit(t: Double): Unit = {
    println(s"temperature -  ${tool.round(t * 1.8d + 32, 2)}")
  }

  temperatureFahrenheit(12)
  temperatureFahrenheit(-24)
  temperatureFahrenheit(-24.7)
}

object task4 extends App {
  def count(str: String): Unit = {
    println(s"Line length \"$str\": ${str.length}")
  }
  count("aaaaa")
}

object task5 extends App {
  def distance (x1: Int, y1: Int, x2: Int, y2: Int): Double = {
    Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
  }

  println(s"Distance - ${tool.round(distance(1, 1, 4, 4), 3)}")
}

object tool{
  def round(d: Double, i: Int): Double = {
    Math.round(d * Math.pow(10, i)) / Math.pow(10, i)

  }
}
