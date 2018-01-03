import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.driver.SQLiteDriver.api._

object ReadSlickApp extends App {
  // Database.forURL("jdbc:sqlite:sample.db", driver="org.sqlite.JDBC")も可
  val db = Database.forConfig("sqlite3")

  try {
    val suppliers = TableQuery[RestaurantTable]
    var selectAll = suppliers.result.map { res => 
        res.foreach(println)
    }
    var selectBetterScore = suppliers.filter(_.score > 4.0).result.map { res => 
        res.foreach(println)
    }
    val future = db.run(selectAll >> selectBetterScore)
    Await.result(future, Duration.Inf)

  } finally db.close
}
