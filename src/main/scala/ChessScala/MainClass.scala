package ChessScala
import ChessScala.controller.IController
import ChessScala.view.gui.{ChessBoardGUI, GUI}
import ChessScala.view.TUI
import com.google.inject.{Guice, Injector}

import scala.io.StdIn

object MainClass {

  val injector: Injector = Guice.createInjector(new ChessModule)
  val controller: IController = injector.getInstance(classOf[IController])

  val tui = new TUI(controller)
  val gui = new GUI(controller)

  @main def main():Unit =
    while(true){
      tui.processInputLine()
    }
}
