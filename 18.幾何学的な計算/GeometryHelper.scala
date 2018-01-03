import com.vividsolutions.jts.geom._
import com.vividsolutions.jts.geom.{Point => JPoint}
import com.vividsolutions.jts.geom.{LineString => JLineString}

object Coord {
  def apply(x: Double, y: Double): Coordinate = new Coordinate(x, y)
}

object Point {
  val factory = new GeometryFactory()
  def apply(x: Double, y: Double): JPoint = 
    factory.createPoint(Coord(x, y))
}

object LineString {
  val factory = new GeometryFactory()
  def apply(coords: Seq[Coordinate]): JLineString =
    factory.createLineString(coords.toArray)
}