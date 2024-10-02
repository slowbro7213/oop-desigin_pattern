package oop.desiginpatterns.construct


// Builder Interface
trait HouseBuilder {
  def setRoofColor(color: String): HouseBuilder
  def setFloor(floor: Int): HouseBuilder
  def setPillar(pillar: Int): HouseBuilder

  def build(): House
}


// Product
case class House(roofColor: String, floor:Int, pillar:Int)


// Concrete Builder
class SigleHouseBuilder extends HouseBuilder {
  private var roofColor = "Red"
  private var floor = 1
  private var pillar = 4

  override def setRoofColor(roofColor: String): HouseBuilder = {
    this.roofColor = roofColor
    this
  }

  override def setFloor(floor: Int): HouseBuilder = {
    this.floor = floor
    this
  }

  override def setPillar(pillar: Int): HouseBuilder = {
    this.pillar = pillar
    this
  }

  override def build(): House = {
    House(roofColor, floor, pillar)
  }
}


object Director {
  val house = new SigleHouseBuilder().setRoofColor("Black").setFloor(2).setPillar(6).build()
  println(house)
}


object DirectorRunner {
  def main(argv: Array[String]): Unit = {
    Director
  }
}
