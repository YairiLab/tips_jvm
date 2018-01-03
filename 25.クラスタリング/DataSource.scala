import math._

object DataSource {
  val rand = new util.Random()
  def generatePoint(x0: Float, y0: Float, r0: Float): (Float, Float) = {
    val r = r0*rand.nextGaussian()
    val a = 2*Pi * rand.nextFloat()
    val x = x0 + r*sin(a)
    val y = y0 + r*cos(a)
    (x.toFloat, y.toFloat)
  }

  def getPoints(): List[(Float, Float)] = {
    val ps1 = (1 to 120).map {
      _ => generatePoint(600, 200, 50)
    }
    val ps2 = (1 to 80).map {
      _ => generatePoint(150, 500, 75)
    }
    val ps3 = (1 to 240).map {
      _ => generatePoint(460, 440, 120)
    }
    List(ps1, ps2, ps3).flatten
  }
}
