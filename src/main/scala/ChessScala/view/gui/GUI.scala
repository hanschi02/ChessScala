package ChessScala.view.gui

import ChessScala.controller.Controller
import ChessScala.model.gameState.*
import ChessScala.util.Observer

import javax.swing.{ImageIcon, WindowConstants}
import scala.swing.*
import scala.swing.event.*



class GUI(controller: Controller) extends Frame with Observer {

  controller.add(this)
  title = "Chess"

  menuBar = new MenuBar {
    contents += new Menu("File") {
      mnemonic = Key.F
      contents += new MenuItem(Action("New") {
        controller.state = new MenuState
        controller.computeInput("1")
        println(controller.state.interpreter.descriptor)
      })
      contents += new MenuItem(Action("Quit") {
        System.exit(0)
      })
    }
    contents += new Menu("Edit") {
      mnemonic = Key.E
      contents += new MenuItem(Action("Undo") {
        controller.computeInput("undo")
      })
      contents += new MenuItem(Action("Redo") {
        controller.computeInput("redo")
      })
    }
  }

  preferredSize = new Dimension(900, 900)

  val button = new Button("New Game")

  listenTo(button)
  reactions += {
    case ButtonClicked(`button`) => onClick()
  }

  def onClick(): Unit ={
    controller.computeInput("1")
  }

  contents = new MenuFrame(controller)


  peer.setLocationRelativeTo(null)

  peer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

  override def update(): Unit =
    if(controller.state.isInstanceOf[GameState]) contents = ChessBoardGUI(controller)
    else contents = new MenuFrame(controller)

  visible = true



}