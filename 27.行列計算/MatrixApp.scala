import org.apache.commons.math3.linear._

object MatrixApp extends App {
  type Array2D = Array[Array[Double]]
  val arr1: Array2D = Array(Array(1, 2, 3), Array(4, 5, 6))
  val arr2: Array2D = Array(Array(11, 12), Array(13, 14), Array(15, 16))

  println("行列の積:")
  val toMatrix = MatrixUtils.createRealMatrix(_:Array2D)
  val List(m, n) = List(arr1, arr2) map toMatrix
  val p = m multiply n
  println(s"$m x $n = $p")

  println("逆行列:")
  val solver = new LUDecomposition(p).getSolver
  val pInverse = solver.getInverse
  println(s"$p x $pInverse ~= ${p multiply pInverse}")
}