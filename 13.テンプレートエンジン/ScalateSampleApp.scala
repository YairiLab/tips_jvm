import org.fusesource.scalate.TemplateEngine

object ScalateSampleApp extends App {
  val engine = new TemplateEngine()
  val params = Map(
    "title" -> "For Loop in Jade",
    "items" -> (1 to 7).toList
  )
  val s = engine.layout("loop.jade", params)
  println(s)
}
