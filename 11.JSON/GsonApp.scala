import com.google.gson._

object GsonApp extends App {
  val gson = new Gson()

  val s = """{ "firstName": "Toshiko", "age": 27 }"""

  val toshiko = gson.fromJson(s, classOf[Person])

  toshiko.aging()

  val mickael = new Person("Mickael", "Specter", 30)
  toshiko.marry(mickael)

  toshiko.goToSpace()

  println(gson.toJson(toshiko))
}