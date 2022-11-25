package ChessScala.model.factory

import ChessScala.model.figureStrategies._

trait Factory(team : Team) {
  
  def createFigure(figure : String) : Figure

}
