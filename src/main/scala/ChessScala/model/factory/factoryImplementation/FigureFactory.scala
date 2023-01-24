package ChessScala.model.factory.factoryImplementation

import ChessScala.model.factory.Factory
import ChessScala.model.figureStrategies.*
import ChessScala.model.figureStrategies.strategyImplementations.{Bishop, Knight, Queen, Rook}

class FigureFactory(team : Team) extends Factory {

  def createFigure(figure : String) : Figure =
    figure.toLowerCase() match
      case "bishop" => new Bishop(team)
      case "rook" => new Rook(team)
      case "knight" => new Knight(team)
      case "queen" => new Queen(team)


}
