package ChessScala.controller
import ChessScala.model.gameState.*
import ChessScala.model.gameState.ProgrammState
import ChessScala.util.{Observable, UndoManager}
import ChessScala.model.interpreter.{Interpreter, MenuInterpreter}
import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions.*


class Controller @Inject() extends Observable with IController {
  
  var output: String = ""
  var state: ProgrammState = newState()
  private val undoManager = new UndoManager

  override def computeInput(input: String): Unit =
    input match
      case "undo" => undo()
      case "redo" => redo()
      case _ => doStep(input)

  override def printDescriptor(): Unit =
    output = state.interpreter.descriptor
    notifyObservers()

  def doStep(input: String): Unit =
    undoManager.doStep(new SetCommand(input, this))
    notifyObservers()

  def undo(): Unit =
    undoManager.undoStep
    notifyObservers()

  def redo(): Unit =
    undoManager.redoStep
    notifyObservers()
}