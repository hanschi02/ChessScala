package ChessScala.model.figureStrategies.figureDecorators

import ChessScala.model.figureStrategies.strategyImplementations.Rook
import ChessScala.model.figureStrategies.{Figure, Team, White}

class CastleRook(team: Team) extends Rook(team){
  override val get: Figure = new Rook(team)
  override val id: Int = if (team == White) 18 else 17
}
