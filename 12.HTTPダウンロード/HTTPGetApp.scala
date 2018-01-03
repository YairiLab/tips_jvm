import com.google.api.client.http._
import com.google.api.client.http.javanet.NetHttpTransport

object HttpGetApp extends App {
  val url = new GenericUrl("http://www.google.com/")

  val transport = new NetHttpTransport()
  val reqFactory = transport.createRequestFactory()
  val req = reqFactory.buildGetRequest(url)

  val res = req.execute()

  print(res.parseAsString())
  res.disconnect()
  transport.shutdown()
}
