package ChessScala.controller
import ChessScala.model.gameState.{MenuState, ProgrammState}
import ChessScala.util.Observable
import ChessScala.model.interpreter.{Interpreter, MenuInterpreter}

class Controller() extends Observable {
  
  var output: String = "test"
  var state : ProgrammState = new MenuState

  def computeInput(input: String): Unit =
    val result = state.handle(input)
    output = result._2
    state = result._1
    notifyObservers()

  def printDescriptor(): Unit =
    output = state.interpreter.descriptor
    notifyObservers()
}