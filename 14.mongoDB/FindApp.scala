// レコードを一つ検索、全件検索、クエリで検索。
// mongoにデータが入っていることが前提。
import com.mongodb._

object FindApp extends App {
  val client = new MongoClient()
  val db     = client.getDB("test")
  val restaurants = db.getCollection("restaurants")

  println("all")
  val all = restaurants.find()
  while(all.hasNext()) {
    val rec = all.next().asInstanceOf[BasicDBObject]
    println(s"- ${rec.getString("name")}")
  }

  println("filter")
  val query    = new BasicDBObject("name", "Brigade")
  val filtered = restaurants.find(query)
  while(filtered.hasNext()) {
    val rec = filtered.next().asInstanceOf[BasicDBObject]
    println(s"- ${rec.getString("address")}")
  }

  println("first")
  val rec = restaurants.findOne()
  println(s"- $rec")
  
  client.close()
}