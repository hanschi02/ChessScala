package ChessScala.model.factory

import ChessScala.model.figureStrategies._

class FigureFactory(team : Team) extends Factory {

  def createFigure(figure : String) : Figure =
    figure.toLowerCase() match
      case "bishop" => new Bishop(team)
      case "rook" => new Rook(team)
      case "knight" => new Knight(team)
      case "queen" => new Queen(team)


}
