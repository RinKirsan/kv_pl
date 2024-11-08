package tasks.lec6

import scala.util.{Failure, Success, Try}

object OptionForComp extends App {
  val o1 = Option(1)
  val o2 = Option.empty[Int]
  val o3 = Option(1)

  val sumOpt = o1.filter(_ > 0).flatMap { i1 =>
    o2.filter(_ > 0).flatMap { i2 =>
      o3.map { i3 =>
        i1 + i2 + i3
      }
    }
  }
  println(sumOpt)

  val sumOpt2 = for{
    i1 <- o1
    if i1 > 0
    i2 <- o2
    if i2 > 0
    i3 <- o3
  } yield i1 + i2 + i3
  println(sumOpt2)
}

object MyClassForComp extends App {
  object ForCompSupport {
    def apply[T](t: T): ForCompSupport[T] =
      if (t == null) ForCompEmpty[T]() else ForCompNotEmpty(t)
  }
  trait ForCompSupport[T] {
    def isEmpty: Boolean = this == ForCompEmpty[T]()
    def get: T
    def map[S](f: T => S): ForCompSupport[S] =
      if (isEmpty) ForCompEmpty[S]() else ForCompNotEmpty(f(this.get))
    def flatMap[S](f: T => ForCompSupport[S]): ForCompSupport[S] =
      if (isEmpty) ForCompEmpty[S]() else f(this.get)
    def withFilter(p: T => Boolean): ForCompSupport[T] =
      if (isEmpty || p(this.get)) this else ForCompEmpty[T]()
  }

  case class ForCompEmpty[T]() extends ForCompSupport[T] {
    override def get: T = throw new Exception("ForCompEmpty.get")
  }
  case class ForCompNotEmpty[T](t: T) extends ForCompSupport[T] {
    override def get: T = t
  }

  val x1_1: ForCompSupport[String] = ForCompSupport[String](null)
  val x1_2: ForCompSupport[Int] = ForCompSupport(1)
  println(x1_1)
  println(x1_2)

  val fst = ForCompNotEmpty(2).map(i => i +i)
  val fst2 = ForCompNotEmpty("1")
  val x = for{
    x <- fst
    if x > 2
    x2 <- fst2
  } yield x + x2
  println(x)
}

object ScalaTry extends App {
  val t = Try(1)
  val b1 = t.isSuccess
  val b2 = t.isFailure

  def mayBeThrow(): Try[Int] = Try{
    throw new Exception("boom")
  }

  val x = mayBeThrow()
  x match {
    case Failure(exception) => println(exception.getMessage)
    case Success(value) => println(value)

    val x1 = x.getOrElse(11)
    println(s"Out x1: $x1")

    val x2: Try[String] = x.map{i =>
      i.toString
    }
    println(s"Out x2: $x2")
  }
}