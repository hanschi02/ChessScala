package ChessScala.controller
import ChessScala.model.gameState.ProgrammState
import ChessScala.util.Command

class SetCommand(input: String, controller: Controller) extends Command {

  val state: ProgrammState = controller.state

  override def doStep(): Unit =
    val result = controller.state.handle(input)
    controller.state = result._1
    controller.output = result._2

  override def undoStep(): Unit =
    controller.state = state


  override def redoStep(): Unit =
    val result = controller.state.handle(input)
    controller.state = result._1
    controller.output = result._2
}