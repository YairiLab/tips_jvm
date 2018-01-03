import scala.collection.JavaConversions._
import com.atilika.kuromoji.ipadic.{Token,Tokenizer}

object TokenizeApp extends App {
  val builder = new Tokenizer.Builder()
  val tokenizer = builder.build()
  for (line <- io.Source.stdin.getLines) {
    for (token <- tokenizer.tokenize(line)) {
      println(token.getSurface() + "\t" + token.getAllFeatures()) 
    }
  }
}