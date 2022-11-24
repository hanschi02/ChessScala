package ChessScala.controller
import ChessScala.util.Observable
import ChessScala.model.interpreter.{Interpreter, MenuInterpreter}

class Controller() extends Observable {
  
  var output: String = "test"

  def computeInput(input: String): Unit =
    notifyObservers()

  def printDescriptor(): Unit =
    notifyObservers()
}