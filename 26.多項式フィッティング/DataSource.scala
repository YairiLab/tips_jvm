object DataSource {
  val rand = new util.Random()
  def func(x: Float): Float = 0.000007F*x*x*x - 0.007F*x*x + 1.6F*x + 280F
  def generatePVector(width: Float): (Float, Float) = {
    val x = width*rand.nextFloat()
    val y = func(x) + 150*rand.nextGaussian().toFloat
    (x, y)
  }
  
  def getPoints(width: Float): List[(Float, Float)] = {
    val ps = (0 to 1200).map {
      _ => generatePVector(width)
    }
    ps.toList
  }
}