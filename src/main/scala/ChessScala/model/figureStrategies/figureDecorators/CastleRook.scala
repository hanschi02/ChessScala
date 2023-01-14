package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.figureStrategies.{Figure, Rook, Team}

class CastleRook(team: Team) extends Rook(team){
  override val get: Figure = new Rook(team)
  
}
