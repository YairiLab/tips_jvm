import java.io.File
import javax.servlet.http._
import freemarker.template.Configuration
import scala.collection.JavaConverters._

class HelloServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, res: HttpServletResponse) {
    val temp = HelloServlet.conf.getTemplate("index.ftlh")
    val writer = res.getWriter
    temp.process(Map("title" -> "Enter something").asJava, writer)
  }

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) {
    val writer = res.getWriter
    writer.print(s"You posted '${req.getParameter("key")}'")
  }
}

object HelloServlet {
  val conf = new Configuration(Configuration.VERSION_2_3_23)
  conf.setDirectoryForTemplateLoading(new File("./src/main/resources"))
}
