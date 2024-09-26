// Abstract Product
trait RDBConnection {
  def paint: String
}


// Concrete Product
class OracleConnection extends RDBConnection {
  def paint: String = "connection for Oracle."
}


class PostgreConnection extends RDBConnection {
  def paint: String = "connection for Postgre."
}


// Abstract Factory
trait DBConnectioonFactory {
  def createRDBConnection: RDBConnection
}


// Concrete Factory
class OracleConnectionFactory extends DBConnectioonFactory {
  def createRDBConnection: RDBConnection = new OracleConnection
}


class PostgreConnectionFactory extends DBConnectioonFactory {
  def createRDBConnection: RDBConnection = new PostgreConnection
}


// Client : Abstract interface 만 가지고 Product 를 생성 및 조작
class Application(factory: RDBConnection) {
  val connection = factory.createButton
  println(button.paint)
}


// Test
object ApplicationRunner {
  def createRDBConnectionConcreteFactory(rdbConnType: String): DBConnectioonFactory = {
    rdb_conn_type match {
      case "ORACLE" => new OracleConnectionFactory
      case "POSTGRE" => new PostgreConnectionFactory
    }
  }

  def main(argv: Array[String]): Unit = {
    var testType = "ORACLE"
    new Application(createRDBConnectionConcreteFactory(testType))  // print oracle connection

    testType = "POSTGRE"
    new Application(createRDBConnectionConcreteFactory(testType))  // print postgre connection
  }
}
