package ChessScala.view.gui

import ChessScala.controller.IController
import ChessScala.model.board.Coordinate

import java.awt.Dimension
import javax.swing.ImageIcon
import scala.swing.*
import scala.util.Try

class MenuFrame(controller: IController) extends FlowPanel {


  class White extends GridPanel(0,1) {
    background = new Color(0xF0D9B5)
    preferredSize = new Dimension(100,100)
    //contents += label
  }

  class Black extends GridPanel(1,1) {
    background = new Color(0xB58863)
    preferredSize = new Dimension(100,100)
  }
  val board: GridPanel = new GridPanel(8,8){
    def paint1(x: Int, y: Int): Unit =
      contents += (if ((x + y) % 2 == 0) new Black else new White)

    (0 to 7).foreach(k=> (0 to 7).foreach(j => this.paint1(k, j)))

  }
  contents += board
}