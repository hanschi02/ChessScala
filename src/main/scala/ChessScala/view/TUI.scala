package ChessScala.view

import scala.io.StdIn
import ChessScala.util.Observer
import ChessScala.controller.IController
import ChessScala.model.interpreter.{Interpreter, MenuInterpreter}

class TUI(controller: IController) extends Observer {

  controller.add(this)

  def processInputLine(): Unit =
    controller.printDescriptor()
    controller.computeInput(StdIn.readLine())

  override def update(): Unit =
    println(controller.output)
}
