import java.sql.{Connection,DriverManager,SQLException}

object ReaderApp extends App {
  Class.forName("org.sqlite.JDBC")
  val conn = DriverManager.getConnection("jdbc:sqlite:sample.db")
  
  val stmt = conn.createStatement()
  val resultSet = stmt.executeQuery("select * from person")
  while (resultSet.next()) {
    val id = resultSet.getInt("id")
    val name = resultSet.getString("name")
    println(s"$id => $name")
  }
  conn.close()
}
