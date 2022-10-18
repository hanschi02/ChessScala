package ChessScala.view

import ChessScala.model.{Interpreter, MenuInterpreter}
import scala.io.StdIn
import ChessScala.util.Observer
import ChessScala.controller.Controller

class TUI(controller: Controller) extends Observer {

  controller.add(this)

  def processInputLine(): Unit =
    controller.printDescriptor()
    controller.computeInput(StdIn.readLine())

  override def update(): Unit = println(controller.output)
}
