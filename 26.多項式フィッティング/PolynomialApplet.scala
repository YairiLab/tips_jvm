import processing.core._

class PolynomialApplet extends PApplet {
  var points: List[(Float, Float)] = null
  var fittedFunction: Float => Float = null

  override def settings() {
    size(800, 800)
    points = DataSource.getPoints(width)
    fittedFunction = PolynomialFitter.getFunction(points)
  }

  override def setup() {
    background(40)

    noStroke()
    fill(220, 20, 80)
    for ((x, y) <- points) {
      ellipse(x, y, 3, 3)
    }

    drawCurve()
  }

  override def draw() {
  }

  private def drawCurve() {
    noFill()
    stroke(180, 200, 250)
    strokeWeight(2)
    beginShape()
    for (x <- 0 until width) {
      val y = fittedFunction(x)
      vertex(x, y)
    }
    endShape()
  }
}