package ChessScala.model.figureStrategies.figureDecorators

import ChessScala.model.figureStrategies.{Black, Team}
import ChessScala.model.figureStrategies.strategyImplementations.Pawn

class EnPassantPawn(team: Team) extends Pawn(team) {
  
  override val id : Int = if (team == Black) 15 else 16
}
