package ChessScala.view

import scala.io.StdIn
import ChessScala.util.Observer
import ChessScala.controller.IController
import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.MenuInterpreter
import com.typesafe.scalalogging.{LazyLogging, Logger}


class TUI(controller: IController) extends Observer with LazyLogging {

  controller.add(this)

  def processInputLine(): Unit =
    controller.printDescriptor()
    controller.computeInput(StdIn.readLine())

  override def update(): Unit =
    logger.info(controller.output)
}
