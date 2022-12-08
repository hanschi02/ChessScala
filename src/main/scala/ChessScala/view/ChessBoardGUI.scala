package ChessScala.view

import ChessScala.controller.Controller
import ChessScala.model.board.Coordinate

import java.awt.Color
import java.awt.Image
import swing.{Color, SimpleSwingApplication, *}
import javax.swing.{ImageIcon, JLabel}
import event.*
import scala.util.Try


class ChessBoardGUI(controller : Controller)  extends FlowPanel {

  val figures = Array.ofDim[Image](2, 6)

  val coordinates = Array.ofDim[Coordinate](8, 8)
  val light = new Color(0xF0D9B5)
  val dark = new Color(0xB58863)
  var buttonPressed : String = ""

  contents += new GridPanel(0 ,8) {

    preferredSize = new Dimension(800, 800)

    for(i <- 1 to 8)
      for(j <- 1 to 8)

        val button = new Button() {

          if ((i+j) % 2 == 1) {
            background = light
          } else {
            background = dark
          }

          Try{
            val id = controller.state.board.get(Coordinate(8-i, j-1)).get.id
            icon = new ImageIcon(FigureImages.getImage(id))
          }
        }

        contents += button

        listenTo(button)
        reactions += {
          case ButtonClicked(`button`) =>
            val input = ('a' + (j - 1)).toChar+""+(9 - i)
            if(buttonPressed.isBlank) {
              buttonPressed = input
            } else {
              controller.computeInput(buttonPressed+input)
              buttonPressed = ""
            }
        }

        val row = i-1
        val column = j-1

        coordinates(row)(column) = Coordinate(i, j)

  }



  visible = true

}