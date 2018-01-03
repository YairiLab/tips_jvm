import processing.core._

class JTSApplet extends PApplet {
  val cs = List(Coord(600, 100), Coord(100, 400), Coord(700, 500))
  val r = 50
  val buff = LineString(cs).buffer(r)
  override def settings() {
    size(800, 600)
  }

  override def setup() {
    strokeWeight(2*r)
    frameRate(6)
  }

  override def draw() {
    background(40)

    for((p, q) <- cs.init.zip(cs.tail)) {
      line(p.x.toFloat, p.y.toFloat, q.x.toFloat, q.y.toFloat)
    }
    
    val mouse = Point(mouseX, mouseY)
    if (buff.contains(mouse)) {
      stroke(200, 200, 100)
    } else {
      stroke(100)
    }
    val d = buff.distance(mouse)
    println(f"Distance: $d%6.1f")
  }
}