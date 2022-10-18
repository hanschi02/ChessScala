package ChessScala
import scala.io
import scala.io.StdIn

class TUI {
  var interpreter: Interpreter = new MenuInterpreter

  def processInputLine(input:String):String =
    val result = interpreter.processInputLine(input)
    interpreter = result._2
    result._1

  def readLine(): Unit =
    println(interpreter.descriptor)
    println(processInputLine(StdIn.readLine()))
}
