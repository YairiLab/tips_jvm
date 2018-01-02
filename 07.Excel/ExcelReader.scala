import java.io.File
import collection.JavaConversions._
import org.apache.poi.ss.usermodel._

object ExcelReaderApp extends App {
  val filename = "population.xls"
  val book = WorkbookFactory.create(new File(filename))
  val sheet = book.head
  val rows = for (i <- (12 to 32)) yield {
    val row = sheet.getRow(i)
    (row.getCell(4), row.getCell(5))
  }
  for (((men, women), i) <- rows.zipWithIndex) {
    println(s"${i*5}-歳: 男 ${men.getNumericCellValue}万人, 女 ${women.getNumericCellValue}万人")
  }
  book.close()
}