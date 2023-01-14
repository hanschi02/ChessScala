package ChessScala.view.gui

import ChessScala.controller.IController
import ChessScala.model.gameState.*
import ChessScala.model.gameState.stateImplementation.{GameState, MenuState, SelectState}
import ChessScala.util.Observer
import ChessScala.model.figureStrategies.White

import javax.swing.{ImageIcon, WindowConstants}
import scala.swing.*
import scala.swing.event.*



class GUI(controller: IController) extends Frame with Observer {

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
      contents += new MenuItem(Action("Save") {
        controller.computeInput("save")
      })
      contents += new MenuItem(Action("Load") {
        controller.computeInput("load")
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
    controller.state match {
      case _: GameState => contents = ChessBoardGUI(controller)
      case _: SelectState => selectTeam()
      case _ => contents = new MenuFrame(controller)
    }

  def selectTeam():Unit =
    val state = controller.state.asInstanceOf[SelectState]
    if (state.team == White) contents = WhitePawnPromotionBoard(controller)
    else contents = BlackPawnPromotionBoard(controller)
  visible = true



}