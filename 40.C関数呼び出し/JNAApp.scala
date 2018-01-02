import com.sun.jna._

object JNAApp extends App {
  val puts = Function.getFunction("c", "puts", Function.C_CONVENTION)
  val arr = Array("hello jna".asInstanceOf[Object])
  puts.invoke(arr)
}