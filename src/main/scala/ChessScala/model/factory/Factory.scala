package ChessScala.model.factory

import ChessScala.model.figureStrategies._

trait Factory {
  
  def createFigure(figure : String) : Figure

}
