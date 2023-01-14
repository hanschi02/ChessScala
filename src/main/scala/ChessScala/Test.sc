import ChessScala.controller.IController
import ChessScala.view.gui.FigureImages

import java.awt.{Color, Image}
import javax.swing.{ImageIcon, JLabel}
import scala.swing.event.*
import scala.swing.*
import scala.util.Try

class BlackPawnPromotionBoard(controller: IController) extends FlowPanel {

  val light = new Color(0xF0D9B5)
  val dark = new Color(0xB58863)

  contents += new GridPanel(0, 4) {

    preferredSize = new Dimension(400, 100)

    for (i <- 1 to 4) {
      val button = new Button() {
        opaque = true
        borderPainted = false

        i match {
          case 1 => icon = new ImageIcon(FigureImages.getImage(4))
            background = dark
          case 2 => icon = new ImageIcon(FigureImages.getImage(2))
            background = light
          case 3 => icon = new ImageIcon(FigureImages.getImage(1))
            background = dark
          case 4 => icon = new ImageIcon(FigureImages.getImage(3))
            background = light

        }
      }
      contents += button
    }
  }


  visible = true

}