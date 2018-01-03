import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.driver.SQLiteDriver.api._

object WriteSlickApp extends App {
  // Database.forURL("jdbc:sqlite:sample.db", driver="org.sqlite.JDBC")も可
  val db = Database.forConfig("sqlite3")
  try {
    val suppliers = TableQuery[RestaurantTable]
    val writeAction = DBIO.seq(
        suppliers.schema.create,
        suppliers += (1, "The Snug", 4),
        suppliers += (2, "The Wrestlers Pub", 5),
        suppliers += (3, "Costa Coffee", 3)
    )

    val future = db.run(writeAction)
    Await.result(future, Duration.Inf)

  } finally db.close
}
