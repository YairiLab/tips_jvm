import java.sql.{Connection,DriverManager,SQLException}

object WriteApp extends App {
  Class.forName("org.sqlite.JDBC")
  val data = Map(
        1 -> "alice",
        2 -> "bob")
  val conn = DriverManager.getConnection("jdbc:sqlite:sample.db")
  
  val createDbStmt = conn.createStatement()
  createDbStmt.executeUpdate("create table person (id integer, name string)")

  for ((id, name) <- data) {
    val insertStmt = conn.prepareStatement("insert into person values(?, ?)")
    insertStmt.setInt(1, id)
    insertStmt.setString(2, name)
    insertStmt.executeUpdate()
  }

  conn.close()
}
