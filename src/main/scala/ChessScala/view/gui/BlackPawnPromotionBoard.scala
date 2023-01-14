package ChessScala.view.gui

import ChessScala.controller.IController

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

      listenTo(button)
      reactions += {
        case ButtonClicked(`button`) =>
          i match {
            case 1 => controller.computeInput("queen")
            case 2 => controller.computeInput("knight")
            case 3 => controller.computeInput("rook")
            case 4 => controller.computeInput("bishop")
          }
      }

    }
  }


   visible = true

}