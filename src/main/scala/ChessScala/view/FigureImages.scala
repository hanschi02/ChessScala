package ChessScala.view

import java.awt.Image
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object FigureImages {

  val color = Array("white", "black")
  val figure = Array("Queen", "Rook", "Bishop", "Pawn", "King", "Knight")
  val figureImg = Array.ofDim[Image](2, 6)


  for(i <- 0 to 1) {
    for(j <- 0 to 5) {
      val bufferedImage: BufferedImage = ImageIO.read(new File("images/chessFigures/"+color(i)+figure(j)+".png"))
      val img: Image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT)
      figureImg(i)(j) = img

    }
  }

  def getImage(id : Int) : Image =
    id match
      case 1 => figureImg(1)(1) // blackRook
      case 2 => figureImg(1)(5) // blackKnight
      case 3 => figureImg(1)(2) // blackBishop
      case 4 => figureImg(1)(0) // blackQueen
      case 5 => figureImg(1)(4) // blackKing
      case 6 => figureImg(1)(3) // blackPawn
      case 7 => figureImg(0)(1) // whiteRook
      case 8 => figureImg(0)(5) // whiteKnight
      case 9 => figureImg(0)(2) // whiteBishop
      case 10 => figureImg(0)(0) // whiteQueen
      case 11 => figureImg(0)(4) // whiteKing
      case 12 => figureImg(0)(3) // whitePawn
    

}
