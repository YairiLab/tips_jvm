import scala.collection.JavaConverters._
import processing.core._
import org.apache.commons.math3.ml.clustering._

class ClusterApplet extends PApplet {
  val colors = List(color(230, 40, 40), color(100, 230, 180), color(180, 210, 240))
  var points: List[(Float, Float)] = null
  var clusters: List[Cluster[Point]] = null

  override def settings() {
    size(800, 800)

    points = DataSource.getPoints()
    val ps = points.map {
      case (x, y) => new Point(x, y)
    }.asJava
    val clusterer = new KMeansPlusPlusClusterer[Point](colors.length)
    clusters = clusterer.cluster(ps).asScala.toList
  }

  override def setup() {
    background(40)
    noStroke()

    for ((cluster, color) <- clusters zip colors) {
      fill(color)
      for (p <- cluster.getPoints.toArray) {
        val p1 = p.asInstanceOf[Point]
        ellipse(p1.x, p1.y, 4, 4)
      }
    }
  }

  override def draw() {
  }
}