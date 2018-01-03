import org.apache.commons.math3.fitting._

object PolynomialFitter {
  def getFunction(points: List[(Float, Float)]): Float => Float = { 
    val obs = new WeightedObservedPoints()
    for ((x, y) <- points) {
      obs.add(x, y)
    }
    val fitter = PolynomialCurveFitter.create(4)
    val coeff = fitter.fit(obs.toList).toList.zipWithIndex.reverse

    println("Done!")
    for ((k, i) <- coeff) {
      println(f"$i: $k%10.6f")
    }

    (x: Float) => 
      val ks = coeff.map {
        case (k, i) => k * Math.pow(x, i)
      }
      ks.sum.toFloat
  }
}