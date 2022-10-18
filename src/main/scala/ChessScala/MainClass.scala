package ChessScala
import ChessScala.controller.Controller
import ChessScala.view.TUI

import scala.io.StdIn

object MainClass {

  val controller = new Controller()
  val tui = new TUI(controller)


  @main def main():Unit =
    while(true){
      tui.processInputLine()
    }
}