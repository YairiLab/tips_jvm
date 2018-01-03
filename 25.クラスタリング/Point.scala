import org.apache.commons.math3.ml.clustering._

class Point(val x: Float, val y: Float) extends Clusterable {
  def getPoint() = Array(x, y)
  override def toString() = f"($x%.1f, $y%.1f)"
}
