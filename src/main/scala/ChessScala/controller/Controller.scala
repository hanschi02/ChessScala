package ChessScala.controller
import ChessScala.ChessModule
import ChessScala.model.gameState.*
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.util.{Observable, UndoManager}
import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.MenuInterpreter
import com.google.inject.name.Names
import com.google.inject.{Guice, Inject, Injector}
import net.codingwell.scalaguice.InjectorExtensions.*


class Controller @Inject() extends IController {
  
  var output: String = ""

  val injector: Injector = Guice.createInjector(new ChessModule)
  var state: ProgrammState = injector.getInstance(classOf[ProgrammState])

  val undoManager = new UndoManager

  override def computeInput(input: String): Unit =
    input match
      case "undo" => undo()
      case "redo" => redo()
      case _ => doStep(input)

  override def printDescriptor(): Unit =
    output = state.interpreter.descriptor
    notifyObservers()

  def doStep(input: String): Unit =
    if (state.isInstanceOf[GameState]) undoManager.doStep(new SetCommand(input, this))
    else new SetCommand(input, this).doStep()
    notifyObservers()

  def undo(): Unit =
    undoManager.undoStep
    notifyObservers()

  def redo(): Unit =
    undoManager.redoStep
    notifyObservers()
}