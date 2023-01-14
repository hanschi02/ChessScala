package ChessScala.view.gui

import ChessScala.controller.IController

import java.awt.{Color, Image}
import javax.swing.{ImageIcon, JLabel}
import scala.swing.event.*
import scala.swing.*
import scala.util.Try

object WhitePawnPromotionBoard extends SimpleSwingApplication {

  val light = new Color(0xF0D9B5)
  val dark = new Color(0xB58863)

  val grid = new GridPanel(0, 4) {

    preferredSize = new Dimension(400, 100)

    for (i <- 1 to 4) {
      val button = new Button() {
        opaque = true
        borderPainted = false

        i match {
          case 1 => icon = new ImageIcon(FigureImages.getImage(10))
                    background = dark
          case 2 => icon = new ImageIcon(FigureImages.getImage(8))
                    background = light
          case 3 => icon = new ImageIcon(FigureImages.getImage(7))
                    background = dark
          case 4 => icon = new ImageIcon(FigureImages.getImage(9))
                    background = light

        }
      }
      contents += button
    }
  }

    def top = new MainFrame {

    contents = grid
    peer.setLocationRelativeTo(null)

  }

  // visible = true

}
