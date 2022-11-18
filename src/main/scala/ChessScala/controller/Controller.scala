package ChessScala.controller
import ChessScala.util.Observable
import ChessScala.model.interpreter.{Interpreter, MenuInterpreter}

class Controller() extends Observable {

  var interpreter: Interpreter = new MenuInterpreter
  var output: String = "test"

  def computeInput(input: String): Unit =
    val result = interpreter.processInputLine(input)
    interpreter = result._2
    output = result._1
    notifyObservers()

  def printDescriptor(): Unit =
    output = interpreter.descriptor
    notifyObservers()
}