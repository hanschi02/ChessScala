package ChessScala
import ChessScala.controller.Controller
import ChessScala.view.gui.{ChessBoardGUI, GUI}
import ChessScala.view.TUI

import scala.io.StdIn

object MainClass {

  val controller = new Controller()
  val tui = new TUI(controller)
  val gui = new GUI(controller)

  @main def main():Unit =
    while(true){
      tui.processInputLine()
    }
}
