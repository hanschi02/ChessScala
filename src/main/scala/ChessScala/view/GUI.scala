package ChessScala.view
import ChessScala.controller.Controller
import ChessScala.model.gameState._
import ChessScala.util.Observer

import javax.swing.ImageIcon
import swing.*
import javax.swing.WindowConstants
import event.*



class GUI(controller: Controller) extends Frame with Observer {

  controller.add(this)



  title = "Chess"

  preferredSize = new Dimension(900, 900)

  val button = new Button("New Game")

  listenTo(button)
  reactions += {
    case ButtonClicked(`button`) => onClick()
  }

  def onClick(): Unit ={
    controller.computeInput("1")
  }

  contents = new GridPanel(0, 1) {

    contents += new Label {
      icon = new ImageIcon("images/logo.png")
    }


    contents += new BoxPanel(Orientation.Horizontal) {
      contents += button
    }
  }

  peer.setLocationRelativeTo(null)

  peer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

  override def update(): Unit = if(controller.state.isInstanceOf[GameState]) contents = ChessBoardGUI(controller)

  visible = true



}