import slick.lifted.ProvenShape
import slick.driver.SQLiteDriver.api._

class RestaurantTable(tag: Tag)
  extends Table[(Int, String, Double)](tag, "RESTAURANT") {

  def id = column[Int]("ID", O.PrimaryKey)
  def name = column[String]("NAME")
  def score = column[Double]("SCORE")

  def * : ProvenShape[(Int, String, Double)] =
    (id, name, score)
}
