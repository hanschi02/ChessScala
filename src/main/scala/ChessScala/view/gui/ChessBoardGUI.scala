package ChessScala.view.gui

import ChessScala.controller.IController
import ChessScala.model.board.Coordinate

import java.awt.{Color, Image}
import javax.swing.{ImageIcon, JLabel}
import scala.swing.event.*
import scala.swing.*
import scala.util.Try


class ChessBoardGUI(controller : IController)  extends FlowPanel {

  val figures: Array[Array[Image]] = Array.ofDim[Image](2, 6)

  val coordinates: Array[Array[Coordinate]] = Array.ofDim[Coordinate](8, 8)
  val light = new Color(0xF0D9B5)
  val dark = new Color(0xB58863)
  var buttonPressed : String = ""


  contents += new GridPanel(0 ,8) {

    preferredSize = new Dimension(800, 800)

    for(i <- 1 to 8)
      for(j <- 1 to 8)

        val button = new Button() {

          opaque = true
          borderPainted = false

          if ((i+j) % 2 == 1) {
            background = light
          } else {
            background = dark
          }

          Try{
            val id = controller.state.board.get(Coordinate(j-1, 8-i)).get.id
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
              println(controller.state.interpreter.descriptor)
            }
        }

        val row = i-1
        val column = j-1

        coordinates(row)(column) = Coordinate(i, j)

  }

  visible = true


}
