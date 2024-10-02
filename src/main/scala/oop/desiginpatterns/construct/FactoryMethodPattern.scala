package oop.designpatterns.construct


// Product Interface
trait Noodle {
  def flavor(): String
}


// Concrete Product
class PadThai extends Noodle {
  override def flavor(): String = "PadThai flavor"
}


class Ramyeon extends Noodle {
  override def flavor(): String = "Ramyeon flavor"
}


// Creator Interface
trait Chef {
  def makeNoodle(): Noodle

  def cook(): Unit = {
    val noodle = makeNoodle()
    println(s"The noodle is ${noodle.flavor()}. Hololok~~")
  }
}


// Concrete Creator
class ThaiChef extends Chef {
  override def makeNoodle(): Noodle = new PadThai()
}


class KoreanChef extends Chef {
  override def makeNoodle(): Noodle = new Ramyeon()
}


object NoodleApp {
  def main(argv: Array[String]): Unit = {
    val chef = new KoreanChef
    chef.cook()
  }
}
