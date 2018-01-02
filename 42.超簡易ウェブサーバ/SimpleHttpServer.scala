import java.io.OutputStream
import java.net.InetSocketAddress
import com.sun.net.httpserver._

class SimpleHandler extends HttpHandler {
  override def handle(ex: HttpExchange) = {
    val response = "Very Simple HttpServer!"
    ex.sendResponseHeaders(200, response.length())
    val oStream = ex.getResponseBody()
    oStream.write(response.getBytes())
    oStream.close()
    println("レスポンス返信")
  }
}

object SimpleHttpServer extends App {
  val addr = new InetSocketAddress("localhost", 8080)
  val httpServer = HttpServer.create(addr, 1)
  httpServer.createContext("/", new SimpleHandler())
  httpServer.start()
  println("サーバ起動")
}