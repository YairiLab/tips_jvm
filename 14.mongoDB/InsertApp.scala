// レコードをインサート。
import com.mongodb._

object InsertApp extends App {
  val brigade = new BasicDBObject("name", "Brigade").append("address", "London")
  val costa   = new BasicDBObject("name", "Costa Cambridge").append("address", "Cambridge")
  val restaurants = List(brigade, costa)

  val client = new MongoClient()
  val db     = client.getDB("test")
  val conn   = db.getCollection("restaurants")
  for(restaurant <- restaurants) {
    conn.insert(restaurant)
  }
  client.close()
}