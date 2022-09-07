package ChessScala

object Main {

  val cell: String = "|" + " " * 8

  val EOL: String = "\n"

  def drawBorder(size: Int): String = "-" * size * 8 + EOL

  def drawLine(size: Int): String = drawBorder(size) + cell * size + EOL

  def drawField(size: Int): String = drawLine(size) * size + drawBorder(size)

  @main def main(): Unit = println(drawField(8))
}
